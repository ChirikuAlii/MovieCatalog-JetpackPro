package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
class TvShowRepo @Inject constructor() {

    fun getDiscoverTvShows(): List<TvShow> {
        return DataDummy.getTvShows()
    }

    fun getDetailTvShow(idTvshow:String) : TvShow {
        var tvShow = TvShow()
        val data = DataDummy.getTvShows()

        data.forEach {
            if(idTvshow == it.id){
                tvShow= it
            }
        }
        return tvShow
    }
}