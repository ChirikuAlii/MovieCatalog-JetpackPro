package id.chirikualii.movie_catalog_android_jetpack_pro.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.ApiResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */


abstract class NetworkBoundResource<ResultType, RequestType> {

    private val result = MediatorLiveData<Results<ResultType>>()

    init {
        result.value = Results.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Results.success(newData)
                }
            }
        }
    }

    private fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Results.loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    CoroutineScope(IO).launch {
                        response.body?.let { saveCallResult(it) }
                        Log.d("Status: ", response.status.name)

                        withContext(Main) {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = Results.success(newData)
                            }
                        }

                    }

                StatusResponse.ERROR -> {
                    onFetchFailed()
                    Log.d("Status : ", response.status.name)
                    result.addSource(dbSource) { newData ->
                        result.value = Results.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Results<ResultType>> = result
}