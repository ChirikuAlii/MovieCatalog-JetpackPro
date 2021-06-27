package id.chirikualii.movie_catalog_android_jetpack_pro.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.MovieDao
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.TvShowDao
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */
@Database(
    entities = [MovieEntity::class,TvShowEntity::class],
    version = 1
)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

    companion object {
        const val DB_NAME = "movie_db"
    }
}