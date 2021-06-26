package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@HiltViewModel
class DetailMoviesViewModel @Inject constructor(private val repo: MovieRepo) :
    ViewModel() {


    fun doLoadDetailMovie(movieId: String): LiveData<Movie> {

        return repo.getDetailMovie(movieId.toInt())
    }

}