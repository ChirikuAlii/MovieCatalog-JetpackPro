package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.abstraction.BaseViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repo: MovieRepo
): BaseViewModel<MoviesViewModel.MoviesState>(){

    sealed class MoviesState {
        data class Success(val data: ArrayList<Movie>): MoviesState()
        data class Failed(val error: String
        ): MoviesState()
        object Loading: MoviesState()
    }

    fun doGetDiscoverMovie(){
        _state.value = MoviesState.Loading
        try {
            viewModelScope.launch {
                val result = repo.getDiscoverMovie()
                val arraylist = ArrayList<Movie>(result)
                Log.d(TAG, "doGetDiscoverMovie: ${Gson().toJsonTree(result)}")
                _state.value = MoviesState.Success(arraylist)
            }
        }catch (e: Exception){
            Log.e(TAG, "doGetDiscoverMovie error: ${e.message}", )
            _state.value = MoviesState.Failed(e.message.toString())
        }

    }
}