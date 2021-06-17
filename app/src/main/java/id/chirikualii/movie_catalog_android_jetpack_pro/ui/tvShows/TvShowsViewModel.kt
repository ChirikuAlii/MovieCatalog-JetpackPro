package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.abstraction.BaseViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val repo: TvShowRepo
): BaseViewModel<TvShowsViewModel.TvShowsState>(){

    sealed class TvShowsState {
        data class Success(val data: ArrayList<TvShow>): TvShowsState()
        data class Failed(val error: String
        ): TvShowsState()
        object Loading: TvShowsState()
    }

    fun doGetDiscoverTvShow(){
        _state.value = TvShowsState.Loading
        try {
            viewModelScope.launch {
                val result = repo.getDiscoverTvShows()
                val arrayList = ArrayList<TvShow>(result)
                Log.d(TAG, "doGetDiscoverTvShows: ${Gson().toJsonTree(result)}")
                _state.value = TvShowsState.Success(arrayList)
            }
        }catch (e: Exception){
            Log.e(TAG, "doGetDiscoverTvShows error: ${e.message}", )
            _state.value = TvShowsState.Failed(e.message.toString())
        }

    }
}