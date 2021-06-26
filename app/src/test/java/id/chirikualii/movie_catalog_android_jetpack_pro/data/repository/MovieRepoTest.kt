package id.chirikualii.movie_catalog_android_jetpack_pro.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import id.chirikualii.movie_catalog_android_jetpack_pro.LiveDataTestUtil
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/**
 * Create by Chiriku Alii on 6/26/21
 * github.com/chirikualii
 */
class MovieRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repo = FakeMovieRepo(remote)

    private val listMovieResponse = DataDummy.getMovieResponseList()

    private val movieId = listMovieResponse[1].id

    private val movieResponse = DataDummy.getMovieResponseList()[1]

    @Test
    fun getDiscoverMovie(){
       runBlocking {
           doAnswer { invocationOnMock ->
               (invocationOnMock.arguments[0] as RemoteDataSource.LoadDiscoverMovieListener).onMoviesLoaded(listMovieResponse)
               null
           }.`when`(remote).discoverMovies(any())
       }

        val data = LiveDataTestUtil.getValue(repo.getDiscoverMovieApi())

        runBlocking {
            verify(remote).discoverMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMovieResponse.size.toLong(), data.size.toLong())
    }

    @Test
    fun getDetailMovie(){
        runBlocking {
            doAnswer { invocationOnMock ->
                (invocationOnMock.arguments[1] as RemoteDataSource.LoadMovieDetailListener).onMovieDetailLoaded(movieResponse)
                null
            }.`when`(remote).movieDetail(eq(movieId), any())
        }

        val data = LiveDataTestUtil.getValue(repo.getDetailMovie(movieId))

        runBlocking {
            verify(remote).movieDetail(eq(movieId), any())
        }

        assertNotNull(data)
        assertEquals(movieResponse.id,data.id.toInt())
    }
}