package id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */

@Dao
interface TvShowDao {

    @Query("SELECT * FROM tv_show")
    fun getTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tv_show WHERE is_favorite = 1")
    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tv_show WHERE tv_show_id = :tvShowId")
    fun getDetailTvShowById(tvShowId: Int) : LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = TvShowEntity::class)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update(entity = TvShowEntity::class)
    fun updateTvShows(tvShow : TvShowEntity)
}