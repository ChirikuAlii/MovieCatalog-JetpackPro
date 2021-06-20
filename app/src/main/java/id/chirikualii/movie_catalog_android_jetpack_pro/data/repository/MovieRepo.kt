package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository


import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import javax.inject.Inject

/**
 * Create by chirikualii on 6/10/21
 * github.com/chirikualii
 */


class MovieRepo @Inject constructor() {

    fun getDiscoverMovie(): List<Movie> {
        return DataDummy.getMovieList()
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