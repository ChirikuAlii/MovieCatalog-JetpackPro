package id.chirikualii.movie_catalog_android_jetpack_pro.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.MovieDao
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.TvShowDao
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */
class LocalDataSource @Inject constructor(private val movieDao: MovieDao,private val tvShowDao: TvShowDao) {

    fun getListMovies() : DataSource.Factory<Int, MovieEntity> = movieDao.getMovies()

    fun getListFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = movieDao.getFavoriteMovies()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = movieDao.getDetailMovieById(movieId)

    fun insertMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)

    fun updateFavoriteMovie(movie: MovieEntity) = movieDao.updateMovie(movie)

    fun getListTvShows() : DataSource.Factory<Int, TvShowEntity> = tvShowDao.getTvShows()

    fun getListFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = tvShowDao.getFavoriteTvShows()

    fun getDetailTvShow(tvShowId: Int) : LiveData<TvShowEntity> = tvShowDao.getDetailTvShowById(tvShowId)

    fun insertTvShows(tvShows: List<TvShowEntity>) = tvShowDao.insertTvShows(tvShows)

    fun updateFavoriteTvShow(tvShow: TvShowEntity) = tvShowDao.updateTvShows(tvShow)


}