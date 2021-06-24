package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote

import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&sort_by=popularity.desc")
    suspend fun discoverMovie() : DiscoverMovieResponse

    @GET("discover/tv?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&sort_by=popularity.desc&page=1")
    suspend fun discoverTvShows() : DiscoverTvShowsResponse
}