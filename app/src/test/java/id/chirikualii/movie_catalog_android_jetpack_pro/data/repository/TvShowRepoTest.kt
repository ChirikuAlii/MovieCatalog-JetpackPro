package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.LiveDataTestUtil
import id.chirikualii.movie_catalog_android_jetpack_pro.PagedListUtil
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.LocalDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

/**
 * Create by Chiriku Alii on 6/26/21
 * github.com/chirikualii
 */
class TvShowRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val repo = FakeTvShowRepo(remote,local)

    private val listTvShow = DataDummy.getTvShows()

    private val tvShow = DataDummy.getTvShows()[1]

    @Test
    fun getDiscoverTvShow() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListTvShows()).thenReturn(dataSourceFactory)
        repo.getDiscoverTvShow()

        val tvShowEntity = Results.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getListTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())

    }

    @Test
    fun getDetailTvShow() {

        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getDetailTvShow(tvShow.tvShowId)).thenReturn(dummyTvShow)

        val data = LiveDataTestUtil.getValue(repo.getDetailTvShow(tvShow.tvShowId))
        verify(local).getDetailTvShow(tvShow.tvShowId)
        assertNotNull(data)
        assertEquals(tvShow.tvShowId, data.tvShowId)

    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListFavoriteTvShows()).thenReturn(dataSourceFactory)
        repo.getFavoriteTvShows()

        val tvShowEntity = Results.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getListFavoriteTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(listTvShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }
}