package id.chirikualii.movie_catalog_android_jetpack_pro.utils.view

import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity

interface OnItemClicked {

    fun onMovieClicked(data: MovieEntity?) {}
    fun onTvShowClicked(data: TvShowEntity?) {}
}