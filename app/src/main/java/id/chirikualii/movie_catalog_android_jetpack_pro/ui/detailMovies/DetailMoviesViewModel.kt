package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.abstraction.BaseViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@HiltViewModel
class DetailMoviesViewModel @Inject constructor(private val repo: MovieRepo) :
    BaseViewModel<DetailMoviesViewModel.DetailMoviesState>() {

    sealed class DetailMoviesState {
        data class Success(val data: Movie) : DetailMoviesState()
        data class Failed(
            val error: String
        ) : DetailMoviesState()

        object Loading : DetailMoviesState()
    }

    fun doLoadDetailMovie(idMovie: String) {

        _state.value = DetailMoviesState.Loading

        try {
            viewModelScope.launch {
                val result = repo.getDetailMovie(idMovie)
                _state.value = DetailMoviesState.Success(result)
            }
        } catch (e: Exception) {
            _state.value = DetailMoviesState.Failed(e.message.toString())
        }

    }
}