package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
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
import org.mockito.junit.MockitoJUnitRunner

/**
 * Create by Chiriku Alii on 6/20/21
 * github.com/chirikualii
 */
@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private val dummyTvShow = DataDummy.getTvShows()[2]
    private val tvShowId = dummyTvShow.tvShowId.toInt()

    private lateinit var mViewModel: DetailTvShowViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: TvShowRepo

    @Mock
    private lateinit var observer: Observer<TvShowEntity>

    @Before
    fun setUp() {
        mViewModel = DetailTvShowViewModel(repo)

    }

    @Test
    fun testDoLoadDetailTvShow() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = dummyTvShow

        `when`(repo.getDetailTvShow(tvShowId)).thenReturn(tvShowDummy)
        repo.getDetailTvShow(tvShowId)

        val tvShow = mViewModel.doLoadDetailTvShow(tvShowId.toString()).value

        assertNotNull(tvShow)
        assertEquals(dummyTvShow.tvShowId, tvShow?.tvShowId)
        assertEquals(dummyTvShow.backdrop, tvShow?.backdrop)
        assertEquals(dummyTvShow.desc, tvShow?.desc)
        assertEquals(dummyTvShow.poster, tvShow?.poster)
        assertEquals(dummyTvShow.releaseDate, tvShow?.releaseDate)
        assertEquals(dummyTvShow.title, tvShow?.title)

        mViewModel.doLoadDetailTvShow(tvShowId.toString()).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)

    }

}