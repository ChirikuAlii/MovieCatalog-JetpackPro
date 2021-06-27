package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.chirikualii.movie_catalog_android_jetpack_pro.data.NetworkBoundResource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.LocalDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.ApiResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by chirikualii on 6/10/21
 * github.com/chirikualii
 */


class MovieRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource) {

    fun getDiscoverMovieApi(): LiveData<ArrayList<Movie>> {
        val movies = MutableLiveData<ArrayList<Movie>>()
        CoroutineScope(IO).launch {

            remoteDataSource.discoverMovies(object : RemoteDataSource.LoadDiscoverMovieListener {
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

    fun getDiscoverMovie(): LiveData<Results<PagedList<MovieEntity>>>{
        return object: NetworkBoundResource<PagedList<MovieEntity> , List<DiscoverMovieResponse.MovieResponse>>(){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
                return  data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<DiscoverMovieResponse.MovieResponse>>> {
               return remoteDataSource.discoverMovies2()
            }

            override fun saveCallResult(data: List<DiscoverMovieResponse.MovieResponse>) {
                val moviesList = ArrayList<MovieEntity>()
                for(it in data){
                    val movie = MovieEntity(
                        movieId =it.id,
                        title = it.title,
                        desc = it.overview,
                        poster = it.posterPath,
                        backdrop = it.backdropPath.toString(),
                        releaseDate = it.releaseDate
                    )
                    moviesList.add(movie)
                }
                localDataSource.insertMovies(moviesList)
            }

        }.asLiveData()
    }

    fun getDetailMovie(movieId: Int) :LiveData<MovieEntity> = localDataSource.getDetailMovie(movieId)

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>{
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteMovies(), config).build()
    }

    fun updateFavoriteMovie(movieEntity: MovieEntity){
        CoroutineScope(IO).launch {
            when(movieEntity.isFavorite){

                0-> {movieEntity.isFavorite = 1}
                1-> {movieEntity.isFavorite = 0}
            }
            localDataSource.updateFavoriteMovie(movieEntity)
        }
    }
}