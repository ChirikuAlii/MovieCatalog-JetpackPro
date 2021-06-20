package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test


/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
class MoviesViewModelTest {

    private lateinit var mViewModel: MoviesViewModel
    private val repo: MovieRepo = MovieRepo()

    @Before
    fun setUp() {
        mViewModel = (MoviesViewModel(repo))
    }

    @Test
    fun testDoGetDiscoverMovie() {
        val movies = mViewModel.doGetDiscoverMovie()
        assertNotNull(movies)
        assertEquals(10, movies.size)

    }
}