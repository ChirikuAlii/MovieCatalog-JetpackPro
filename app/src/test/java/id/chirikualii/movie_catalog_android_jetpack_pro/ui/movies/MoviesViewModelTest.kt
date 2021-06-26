package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.ApiClient
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private val dummyMovies = DataDummy.getMovieList()
    private lateinit var mViewModel: MoviesViewModel

    @Mock
    private lateinit var repo: MovieRepo

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer :Observer<ArrayList<Movie>>

    @Before
    fun setUp() {
        mViewModel = (MoviesViewModel(repo))
    }

    @Test
    fun testDoGetDiscoverMovie()  {
        val movies = MutableLiveData<ArrayList<Movie>>()
        val arrayList = arrayListOf<Movie>()
        arrayList.addAll(dummyMovies)
        movies.value = arrayList

        `when`(repo.getDiscoverMovieApi()).thenReturn(movies)

        val dataListMovie = mViewModel.doGetDiscoverMovieApi().value

        verify(repo).getDiscoverMovieApi()
        assertNotNull(dataListMovie)
        assertEquals(10, dataListMovie?.size)

        mViewModel.doGetDiscoverMovieApi().observeForever(observer)
        verify(observer).onChanged(arrayList)

    }
}