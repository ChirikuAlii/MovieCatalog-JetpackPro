package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.ApiService
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
class TvShowRepo @Inject constructor(val service : ApiService) {

    suspend fun getDiscoverTvShows() : DiscoverTvShowsResponse{
        return service.discoverTvShows()
    }
}