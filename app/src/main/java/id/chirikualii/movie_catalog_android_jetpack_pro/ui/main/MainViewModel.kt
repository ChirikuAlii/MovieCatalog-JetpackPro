package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.abstraction.BaseViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MovieRepo):BaseViewModel<MainViewModel.MainState>(){

    sealed class MainState {
        data class Success(val data: List<DiscoverMovieResponse.MovieResponse>): MainState()
        data class Failed(val error: String
        ): MainState()
        object Loading: MainState()
    }

}