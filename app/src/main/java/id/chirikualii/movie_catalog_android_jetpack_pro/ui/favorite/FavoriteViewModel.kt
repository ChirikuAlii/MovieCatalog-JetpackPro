package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/28/21
 * github.com/chirikualii
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val movieRepo: MovieRepo,
    val tvShowRepo: TvShowRepo
) : ViewModel() {

    fun doGetMoviesFavorite(): LiveData<PagedList<MovieEntity>> {
        return movieRepo.getFavoriteMovies()
    }

    fun doGetTvShowsFavorite(): LiveData<PagedList<TvShowEntity>>{
        return tvShowRepo.getFavoriteTvShows()
    }

}