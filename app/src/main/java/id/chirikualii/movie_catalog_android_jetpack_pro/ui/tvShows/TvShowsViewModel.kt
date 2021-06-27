package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val repo: TvShowRepo
) : ViewModel() {

    fun doGetDiscoverTvShow(): LiveData<Results<PagedList<TvShowEntity>>> {
        return repo.getDiscoverTvShow()

    }

}