package id.chirikualii.movie_catalog_android_jetpack_pro.utils.view

import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow

interface OnItemClicked {

    fun onMovieClicked(data: Movie) {}
    fun onTvShowClicked(data: TvShow) {}
}