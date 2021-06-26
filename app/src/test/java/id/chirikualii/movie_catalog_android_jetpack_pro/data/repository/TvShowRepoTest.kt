package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.LiveDataTestUtil
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/**
 * Create by Chiriku Alii on 6/26/21
 * github.com/chirikualii
 */
class TvShowRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repo = FakeTvShowRepo(remote)

    private val listTvShowResponse = DataDummy.getTvShowResponseList()

    private val tvShowId = listTvShowResponse[1].id

    private val tvShowResponse = DataDummy.getTvShowResponseList()[1]

    @Test
    fun getDiscoverTvShow(){
        runBlocking {
            doAnswer { invocationOnMock ->
                (invocationOnMock.arguments[0] as RemoteDataSource.LoadDiscoverTvShowListener).onTvShowsLoaded(listTvShowResponse)
                null
            }.`when`(remote).discoverTvShows(any())
        }

        val data = LiveDataTestUtil.getValue(repo.getDiscoverTvShowsApi())

        runBlocking {
            verify(remote).discoverTvShows(any())
        }

        assertNotNull(data)
        assertEquals(listTvShowResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getDetailTvShow(){
        runBlocking {
            doAnswer { invocationOnMock ->
                (invocationOnMock.arguments[1] as RemoteDataSource.LoadTvShowDetailListener).onTvShowDetailLoaded(tvShowResponse)
                null
            }.`when`(remote).tvShowDetail(eq(tvShowId), any())
        }

        val data = LiveDataTestUtil.getValue(repo.getDetailTvShow(tvShowId))

        runBlocking {
            verify(remote).tvShowDetail(eq(tvShowId), any())
        }

        assertNotNull(data)
        assertEquals(tvShowResponse.id, data.id.toInt())
    }
}