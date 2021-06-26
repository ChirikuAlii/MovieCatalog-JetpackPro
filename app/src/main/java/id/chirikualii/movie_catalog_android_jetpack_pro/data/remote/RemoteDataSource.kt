package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote

import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
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