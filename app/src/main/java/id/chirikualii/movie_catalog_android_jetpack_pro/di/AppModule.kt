package id.chirikualii.movie_catalog_android_jetpack_pro.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.chirikualii.movie_catalog_android_jetpack_pro.data.Session
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSession(@ApplicationContext context: Context, gson: Gson): Session {
        return Session(context, gson)
    }

}