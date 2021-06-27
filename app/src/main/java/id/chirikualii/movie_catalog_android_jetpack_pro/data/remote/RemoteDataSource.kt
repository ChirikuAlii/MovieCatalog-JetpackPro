package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.ApiResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/25/21
 * github.com/chirikualii
 */
class RemoteDataSource @Inject constructor(private val service: ApiService) {

    suspend fun discoverMovies(
        listener: LoadDiscoverMovieListener
    ) {
        EspressoIdlingResource.increment()
        service.discoverMovie().await().movieResponses.let { movies ->
            listener.onMoviesLoaded(
                movies
            )
            EspressoIdlingResource.decrement()
        }
    }

    fun discoverMovies2(): LiveData<ApiResponse<List<DiscoverMovieResponse.MovieResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<DiscoverMovieResponse.MovieResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.discoverMovie().await()
                result.postValue(ApiResponse.success(response.movieResponses))
            }catch (e:Exception){
                result.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return result
    }

     fun discoverTvShows2(): LiveData<ApiResponse<List<DiscoverTvShowsResponse.TvShowsResponse>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<DiscoverTvShowsResponse.TvShowsResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.discoverTvShows().await()
                result.postValue(ApiResponse.success(response.results))
            }catch (e:Exception){
                result.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return result
    }

    suspend fun movieDetail(
        movieId: Int,
        listener: LoadMovieDetailListener
    ) {
        EspressoIdlingResource.increment()
        service.detailMovie(movieId).await().let { detailMovie ->
            listener.onMovieDetailLoaded(detailMovie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun discoverTvShows(
        listener: LoadDiscoverTvShowListener
    ) {
        EspressoIdlingResource.increment()
        service.discoverTvShows().await().results.let { tvShows ->
            listener.onTvShowsLoaded(tvShows)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun tvShowDetail(
        tvShowId: Int,
        listener: LoadTvShowDetailListener
    ) {
        EspressoIdlingResource.increment()
        service.detailTvShow(tvShowId).await().let { detailTvShow ->
            listener.onTvShowDetailLoaded(detailTvShow)
            EspressoIdlingResource.decrement()
        }
    }
//    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
//        EspressoIdlingResource.increment()
//        ApiClient.instance.getDetailMovie(movieId).await().let { movie ->
//            callback.onMovieDetailReceived(
//                movie
//            )
//            EspressoIdlingResource.decrement()
//        }
//    }
//
//    suspend fun getTvShowOnTheAir(callback: LoadOnTheAirTvShowCallback) {
//        EspressoIdlingResource.increment()
//        ApiClient.instance.getTvShowOnTheAir().await().result?.let { listTvShow ->
//            callback.onAllTvShowsReceived(
//                listTvShow
//            )
//            EspressoIdlingResource.decrement()
//        }
//    }
//
//    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
//        EspressoIdlingResource.increment()
//        ApiClient.instance.getDetailTvShow(tvShowId).await().let { tvShow ->
//            callback.onTvShowDetailReceived(
//                tvShow
//            )
//            EspressoIdlingResource.decrement()
//        }
//    }

    interface LoadDiscoverMovieListener {
        fun onMoviesLoaded(movieResponse: List<DiscoverMovieResponse.MovieResponse>)
    }

    interface LoadMovieDetailListener {
        fun onMovieDetailLoaded(movieResponse: DiscoverMovieResponse.MovieResponse)
    }

    interface LoadDiscoverTvShowListener {
        fun onTvShowsLoaded(tvShowResponse: List<DiscoverTvShowsResponse.TvShowsResponse>)
    }

    interface LoadTvShowDetailListener {
        fun onTvShowDetailLoaded(tvShowResponse: DiscoverTvShowsResponse.TvShowsResponse)
    }
}