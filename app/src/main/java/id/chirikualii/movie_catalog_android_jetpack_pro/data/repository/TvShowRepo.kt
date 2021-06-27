package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.chirikualii.movie_catalog_android_jetpack_pro.data.NetworkBoundResource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.LocalDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.ApiResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
class TvShowRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ) {

    fun getDiscoverTvShowsApi(): LiveData<ArrayList<TvShow>> {
        val tvShows = MutableLiveData<ArrayList<TvShow>>()
        CoroutineScope(Dispatchers.IO).launch {

            remoteDataSource.discoverTvShows(object : RemoteDataSource.LoadDiscoverTvShowListener {
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

        return tvShows
    }

    fun getDiscoverTvShow(): LiveData<Results<PagedList<TvShowEntity>>>{
        return object: NetworkBoundResource<PagedList<TvShowEntity>, List<DiscoverTvShowsResponse.TvShowsResponse>>(){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean {
                return  data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<ApiResponse<List<DiscoverTvShowsResponse.TvShowsResponse>>> {
                return remoteDataSource.discoverTvShows2()
            }

            override fun saveCallResult(data: List<DiscoverTvShowsResponse.TvShowsResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                data.map {
                    TvShowEntity(
                        tvShowId = it.id,
                        title = it.name,
                        desc = it.overview,
                        poster = it.posterPath,
                        backdrop = it.backdropPath.toString(),
                        releaseDate = it.firstAirDate
                    )
                }.forEach {
                    tvShowList.add(it)
                }
                localDataSource.insertTvShows(tvShowList)
            }

        }.asLiveData()
    }

    fun getDetailTvShow(tvShowId: Int):LiveData<TvShowEntity> = localDataSource.getDetailTvShow(tvShowId)

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>>{
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteTvShows(), config).build()
    }

    fun updateFavoriteTvShow(tvShow:TvShowEntity){
        CoroutineScope(Dispatchers.IO).launch {
            when(tvShow.isFavorite){
                0 -> {tvShow.isFavorite = 1}
                1 -> {tvShow.isFavorite = 0}
            }
            localDataSource.updateFavoriteTvShow(tvShow)
        }
    }

}