package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {


    private lateinit var mViewModel: MoviesViewModel

    @Mock
    private lateinit var repo: MovieRepo

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Results<PagedList<MovieEntity>>>

    @Mock
    private lateinit var moviesPagedList: PagedList<MovieEntity>
    @Before
    fun setUp() {
        mViewModel = (MoviesViewModel(repo))
    }

    @Test
    fun doGetDiscoverMovie() {
        val dummyMovies = Results.success(moviesPagedList)
        `when`(dummyMovies.data?.size).thenReturn(10)

        val movies = MutableLiveData<Results<PagedList<MovieEntity>>>()
        movies.value = dummyMovies

        `when`(repo.getDiscoverMovie()).thenReturn(movies)
        val movieEntity = mViewModel.doGetDiscoverMovieApi().value?.data
        verify(repo).getDiscoverMovie()
        assertNotNull(movieEntity)
        assertEquals(10,movieEntity?.size)

        mViewModel.doGetDiscoverMovieApi().observeForever(observer)
        verify(observer).onChanged(dummyMovies)

    }
}