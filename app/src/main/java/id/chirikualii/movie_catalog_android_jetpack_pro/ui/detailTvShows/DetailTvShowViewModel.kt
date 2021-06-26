package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */

@HiltViewModel
class DetailTvShowViewModel @Inject constructor(private val repo: TvShowRepo) : ViewModel() {

    fun doLoadDetailTvShow(tvShowId: String): LiveData<TvShow> {
        return repo.getDetailTvShow(tvShowId.toInt())
    }
}