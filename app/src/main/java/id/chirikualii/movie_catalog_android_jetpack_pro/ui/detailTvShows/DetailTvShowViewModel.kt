package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

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

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun doLoadDetailTvShow(): TvShow {
        return repo.getDetailTvShow(tvShowId)
    }
}