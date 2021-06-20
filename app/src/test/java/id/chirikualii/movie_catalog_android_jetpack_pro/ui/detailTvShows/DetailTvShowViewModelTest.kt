package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
class DetailTvShowViewModelTest {

    private lateinit var mViewModel: DetailTvShowViewModel
    val dummyTvShow = DataDummy.getTvShows()[1]
    val tvShowId = dummyTvShow.id

    @Before
    fun setUp() {
        mViewModel = DetailTvShowViewModel(TvShowRepo())
        mViewModel.setSelectedTvShow(tvShowId)

    }

    @Test
    fun testDoLoadDetailTvShow() {
        mViewModel.setSelectedTvShow(dummyTvShow.id)
        val tvShow = mViewModel.doLoadDetailTvShow()
        assertNotNull(tvShow)

        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.backdrop, tvShow.backdrop)
        assertEquals(dummyTvShow.overview, tvShow.overview)
        assertEquals(dummyTvShow.poster, tvShow.poster)
        assertEquals(dummyTvShow.releaseDate, tvShow.releaseDate)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.vote, tvShow.vote)
    }

}