package id.chirikualii.movie_catalog_android_jetpack_pro.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.Session
import javax.inject.Singleton

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideSession(@ApplicationContext context: Context, gson: Gson) : Session {
        return Session(context,gson)
    }
}