package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/15/21
 * github.com/chirikualii
 */
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repo: MovieRepo
) : ViewModel() {
    val listMovieMutableLiveData = MutableLiveData<ArrayList<Movie>>()
    lateinit var listMovieLiveData : LiveData<ArrayList<Movie>>
    fun doGetDiscoverMovie(): ArrayList<Movie> {
        val result = repo.getDiscoverMovie()
        return ArrayList(result)
    }

    fun doGetDiscoverMovieApi() :LiveData<ArrayList<Movie>>{
//        EspressoIdlingResource.increment()
//        var listMovie = arrayListOf<Movie>()
//        lateinit var discoverMovieResponse : DiscoverMovieResponse
//        val job = viewModelScope.launch(Dispatchers.IO) {
//            try {
//                listMovie = repo.getDiscoverMovieApi()
//                listMovieMutableLiveData.value= (listMovie)
//            }catch (e:Exception){
//                Log.e(MoviesViewModel::class.java.simpleName, "doGetDiscoverMovieApi: error :${e.message}", )
//            }
//        }
//
//        job.invokeOnCompletion {
//            viewModelScope.launch(Dispatchers.Main) {
//                EspressoIdlingResource.decrement()
//                listMovieMutableLiveData.value = listMovie
//                Log.d(MoviesViewModel::class.java.simpleName, "doGetDiscoverMovieApi: ${Gson().toJsonTree(listMovie)}")
//            }
//        }

        return repo.getDiscoverMovieApi()

    }
}