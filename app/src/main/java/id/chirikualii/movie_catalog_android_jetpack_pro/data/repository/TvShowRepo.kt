package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
class TvShowRepo @Inject constructor(val remoteDataSource: RemoteDataSource) {

    fun getDiscoverTvShowsApi() : LiveData<ArrayList<TvShow>> {
        val tvShows = MutableLiveData<ArrayList<TvShow>>()
        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.discoverTvShows(object : RemoteDataSource.LoadDiscoverTvShowListener{
                override fun onTvShowsLoaded(tvShowResponse: List<DiscoverTvShowsResponse.TvShowsResponse>) {
                    val tvShowList = ArrayList<TvShow>()
                        tvShowResponse.map {
                        TvShow(
                            id = it.id.toString(),
                            title = it.name,
                            overview = it.overview,
                            poster = it.posterPath,
                            backdrop = it.backdropPath.toString(),
                            vote = it.voteAverage.toString(),
                            releaseDate = it.firstAirDate
                        )
                    }.forEach {
                        tvShowList.add(it)
                    }
                    tvShows.postValue(tvShowList)
                }

            })
        }

        Log.d(MovieRepo::class.java.simpleName, "doGetDiscoverMovieApi: ${Gson().toJsonTree(tvShows)}")
        return tvShows
    }

    fun getDetailTvShow(tvShowId : Int): LiveData<TvShow> {
        val result = MutableLiveData<TvShow>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.tvShowDetail(tvShowId,object : RemoteDataSource.LoadTvShowDetailListener{
                override fun onTvShowDetailLoaded(tvShowResponse: DiscoverTvShowsResponse.TvShowsResponse) {
                    tvShowResponse.let {
                        val tvShow = TvShow(
                            id = it.id.toString(),
                            title = it.name,
                            overview = it.overview,
                            poster = it.posterPath,
                            backdrop = it.backdropPath.toString(),
                            vote = it.voteAverage.toString(),
                            releaseDate = it.firstAirDate
                        )
                        result.postValue(tvShow)
                    }
                }

            })
        }
        return result
    }
}