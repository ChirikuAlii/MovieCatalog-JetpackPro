package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
class DetailMoviesViewModelTest {

    private lateinit var mViewModel: DetailMoviesViewModel
    val dummyMovie = DataDummy.getMovieList()[1]
    val movieId = dummyMovie.id

    @Before
    fun setUp() {
        mViewModel = DetailMoviesViewModel(MovieRepo())
        mViewModel.setSelectedMovie(movieId)

    }

    @Test
    fun testDoLoadDetailMovie() {
        mViewModel.setSelectedMovie(dummyMovie.id)
        val movie = mViewModel.doLoadDetailMovie()
        assertNotNull(movie)

        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.backdrop, movie.backdrop)
        assertEquals(dummyMovie.overview, movie.overview)
        assertEquals(dummyMovie.poster, movie.poster)
        assertEquals(dummyMovie.releaseDate, movie.releaseDate)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.vote, movie.vote)
    }
}