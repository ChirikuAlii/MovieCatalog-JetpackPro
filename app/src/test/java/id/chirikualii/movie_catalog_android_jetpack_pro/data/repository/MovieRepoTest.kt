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
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.RemoteDataSource
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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
class MovieRepoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val repo = FakeMovieRepo(remote,local)

    private val listMovie = DataDummy.getMovieList()



    private val movie = DataDummy.getMovieList()[1]

    @Test
    fun getDiscoverMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int,MovieEntity>
        `when`(local.getListMovies()).thenReturn(dataSourceFactory)
        repo.getDiscoverMovie()

        val movieEntity = Results.success(PagedListUtil.mockPagedList(DataDummy.getMovieList()))
        verify(local).getListMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(),movieEntity.data?.size?.toLong())

    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()

        dummyMovie.value = movie
        `when`(local.getDetailMovie(movie.movieId)).thenReturn(dummyMovie)

        val data = LiveDataTestUtil.getValue(repo.getDetailMovie(movie.movieId))

        verify(local).getDetailMovie(movie.movieId)
        assertNotNull(data)
        assertEquals(movie.movieId, data.movieId)
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>

        `when`(local.getListFavoriteMovies()).thenReturn(dataSourceFactory)
        repo.getFavoriteMovies()

        val movieEntity = Results.success(PagedListUtil.mockPagedList(DataDummy.getMovieList()))

        verify(local).getListFavoriteMovies()
        assertNotNull(movieEntity.data)
        assertEquals(listMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }
}