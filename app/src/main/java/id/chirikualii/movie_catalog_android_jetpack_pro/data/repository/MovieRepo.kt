package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.ApiService
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import javax.inject.Inject

/**
 * Create by chirikualii on 6/10/21
 * github.com/chirikualii
 */

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */

class MovieRepo  @Inject constructor(val service: ApiService){

   suspend fun getDiscoverMovie() :DiscoverMovieResponse{
        return service.discoverMovie()
    }
}