package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.abstraction.BaseViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */

@HiltViewModel
class DetailTvShowViewModel @Inject constructor(private val repo: TvShowRepo) :
    BaseViewModel<DetailTvShowViewModel.DetailTvShowsState>() {

    sealed class DetailTvShowsState {
        data class Success(val data: TvShow) : DetailTvShowsState()
        data class Failed(
            val error: String
        ) : DetailTvShowsState()

        object Loading : DetailTvShowsState()
    }

    fun doLoadDetailMovie(idTvShow: String) {

        _state.value = DetailTvShowsState.Loading

        try {
            viewModelScope.launch {
                val result = repo.getDetailTvShow(idTvShow)
                _state.value = DetailTvShowsState.Success(result)
            }
        } catch (e: Exception) {
            _state.value = DetailTvShowsState.Failed(e.message.toString())
        }

    }
}