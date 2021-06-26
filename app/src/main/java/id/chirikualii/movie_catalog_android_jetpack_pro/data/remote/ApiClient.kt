package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create by Chiriku Alii on 6/24/21
 * github.com/chirikualii
 */
object ApiClient {

    private val httpClient = OkHttpClient.Builder().apply {

    }.build()

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder().apply {
            client(httpClient)
            baseUrl("https://api.themoviedb.org/3/")
            addConverterFactory(GsonConverterFactory.create())
        }
    }

    val service: ApiService by lazy {
        retrofit
            .build()
            .create(ApiService::class.java)
    }
}