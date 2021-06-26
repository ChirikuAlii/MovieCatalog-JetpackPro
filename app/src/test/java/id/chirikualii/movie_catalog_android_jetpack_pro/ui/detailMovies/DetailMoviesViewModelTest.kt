package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@RunWith(MockitoJUnitRunner::class)
class DetailMoviesViewModelTest {

    private val dummyMovie = DataDummy.getMovieList()[2]
    private val movieId = dummyMovie.id.toInt()

    private lateinit var mViewModel: DetailMoviesViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: MovieRepo

    @Mock
    private lateinit var observer: Observer<Movie>

    @Before
    fun setUp() {
        mViewModel = DetailMoviesViewModel(repo)

    }

    @Test
    fun testDoLoadDetailMovie() {
        val movieDummy = MutableLiveData<Movie>()
        movieDummy.value = dummyMovie

        `when`(repo.getDetailMovie(movieId)).thenReturn(movieDummy)

        val movie = mViewModel.doLoadDetailMovie(movieId.toString()).value

        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie?.id)
        assertEquals(dummyMovie.backdrop, movie?.backdrop)
        assertEquals(dummyMovie.overview, movie?.overview)
        assertEquals(dummyMovie.poster, movie?.poster)
        assertEquals(dummyMovie.releaseDate, movie?.releaseDate)
        assertEquals(dummyMovie.title, movie?.title)
        assertEquals(dummyMovie.vote, movie?.vote)

        mViewModel.doLoadDetailMovie(movieId.toString()).observeForever(observer)
        verify(observer).onChanged(dummyMovie)

    }

}