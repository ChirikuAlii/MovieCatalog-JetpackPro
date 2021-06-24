package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository


import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.ApiService
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import javax.inject.Inject

/**
 * Create by chirikualii on 6/10/21
 * github.com/chirikualii
 */


class MovieRepo @Inject constructor(val service: ApiService) {

    fun getDiscoverMovie(): List<Movie> {
        return DataDummy.getMovieList()
    }

    suspend fun getDiscoverMovieApi() :DiscoverMovieResponse{

        return service.discoverMovie()
    }

    fun getDetailMovie(idMovie: String): Movie {
        var movie = Movie()
        val data = DataDummy.getMovieList()

        data.forEach {
            if (idMovie == it.id) {
                movie = it
            }
        }
        return movie
    }
}