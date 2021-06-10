package id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response


import com.google.gson.annotations.SerializedName

data class DiscoverTvShowsResponse(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val results: List<TvShowsResponse> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
){
   data class TvShowsResponse(
       @SerializedName("backdrop_path")
       val backdropPath: String = "",
       @SerializedName("first_air_date")
       val firstAirDate: String = "",
       @SerializedName("genre_ids")
       val genreIds: List<Int> = listOf(),
       @SerializedName("id")
       val id: Int = 0,
       @SerializedName("name")
       val name: String = "",
       @SerializedName("origin_country")
       val originCountry: List<String> = listOf(),
       @SerializedName("original_language")
       val originalLanguage: String = "",
       @SerializedName("original_name")
       val originalName: String = "",
       @SerializedName("overview")
       val overview: String = "",
       @SerializedName("popularity")
       val popularity: Double = 0.0,
       @SerializedName("poster_path")
       val posterPath: String = "",
       @SerializedName("vote_average")
       val voteAverage: Double = 0.0,
       @SerializedName("vote_count")
       val voteCount: Int = 0
   )
}