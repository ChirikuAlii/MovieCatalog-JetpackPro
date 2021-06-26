package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Create by Chiriku Alii on 6/26/21
 * github.com/chirikualii
 */
class FakeMovieRepo(private val remoteDataSource: RemoteDataSource) {

    fun getDiscoverMovieApi() : LiveData<ArrayList<Movie>> {
        val movies = MutableLiveData<ArrayList<Movie>>()
        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.discoverMovies(object : RemoteDataSource.LoadDiscoverMovieListener{
                override fun onMoviesLoaded(movieResponse: List<DiscoverMovieResponse.MovieResponse>) {
                    val moviesList = ArrayList<Movie>()
                    movieResponse.map {
                        Movie(
                            id = it.id.toString(),
                            title = it.title,
                            overview = it.overview,
                            poster = it.posterPath,
                            backdrop = it.backdropPath.toString(),
                            vote = it.voteAverage.toString(),
                            releaseDate = it.releaseDate
                        )
                    }.forEach {
                        moviesList.add(it)
                    }
                    movies.postValue(moviesList)
                }

            })
        }

        return movies
    }
    fun getDetailMovie(movieId : Int): LiveData<Movie> {
        val result = MutableLiveData<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.movieDetail(movieId,object : RemoteDataSource.LoadMovieDetailListener{
                override fun onMovieDetailLoaded(movieResponse: DiscoverMovieResponse.MovieResponse) {
                    movieResponse.let {
                        val movie = Movie(
                            id = it.id.toString(),
                            title = it.title,
                            overview = it.overview,
                            poster = it.posterPath,
                            backdrop = it.backdropPath.toString(),
                            vote = it.voteAverage.toString(),
                            releaseDate = it.releaseDate
                        )
                        result.postValue(movie)
                    }
                }

            })
        }
        return result
    }
}