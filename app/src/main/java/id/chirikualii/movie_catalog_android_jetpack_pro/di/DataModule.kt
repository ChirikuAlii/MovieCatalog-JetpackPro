package id.chirikualii.movie_catalog_android_jetpack_pro.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.MovieDb
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.MovieDao
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.dao.TvShowDao
import javax.inject.Singleton

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) : MovieDb {
        return Room.databaseBuilder(
            context,
            MovieDb::class.java,
            MovieDb.DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(database : MovieDb): MovieDao {
        return database.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(database: MovieDb): TvShowDao {
        return database.tvShowDao()
    }
}