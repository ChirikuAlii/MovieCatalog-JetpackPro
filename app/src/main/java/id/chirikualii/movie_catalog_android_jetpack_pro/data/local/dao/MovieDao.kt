package id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */
@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie WHERE is_favorite = 1")
    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie WHERE movie_id = :movieId")
    fun getDetailMovieById(movieId: Int) : LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = MovieEntity::class)
    fun insertMovies(movies: List<MovieEntity>)

    @Update(entity = MovieEntity::class)
    fun updateMovie(movie : MovieEntity)

}