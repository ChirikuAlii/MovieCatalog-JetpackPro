package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
class TvShowsViewModelTest {

    @Before
    fun setUp() {
        mViewModel = (TvShowsViewModel(repo))
    }

    @Test
    fun testDoGetDiscoverTvShow() {
        val movies = mViewModel.doGetDiscoverTvShow()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    private lateinit var mViewModel: TvShowsViewModel
    private val repo: TvShowRepo = TvShowRepo()

}