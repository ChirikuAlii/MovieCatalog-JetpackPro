package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
class TvShowRepo {

    fun getDiscoverTvShows(): List<TvShow> {
        return DataDummy.getTvShows()
    }
}