package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote

import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("discover/movie?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&sort_by=popularity.desc")
    fun discoverMovie() : Call<DiscoverMovieResponse>

    @GET("movie/{movie_id}?api_key=3b980052023e8e6898f4578a6972740b")
    fun detailMovie(
        @Path("movie_id")movieId :Int
    ) :Call<DiscoverMovieResponse.MovieResponse>

    @GET("discover/tv?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&sort_by=popularity.desc&page=1")
    fun discoverTvShows() : Call<DiscoverTvShowsResponse>

    @GET("tv/{tv_show_id}?api_key=3b980052023e8e6898f4578a6972740b")
    fun detailTvShow(
        @Path("tv_show_id")tvShowId :Int
    ) :Call<DiscoverTvShowsResponse.TvShowsResponse>
}