package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repo: MovieRepo
) : ViewModel() {

    fun doGetDiscoverMovieApi(): LiveData<Results<PagedList<MovieEntity>>> {
        return repo.getDiscoverMovie()
    }
}