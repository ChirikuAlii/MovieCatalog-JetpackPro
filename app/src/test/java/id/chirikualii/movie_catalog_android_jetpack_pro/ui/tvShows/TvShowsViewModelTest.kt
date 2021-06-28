package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Results
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
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
class TvShowsViewModelTest {


    private lateinit var mViewModel: TvShowsViewModel

    @Mock
    private lateinit var repo: TvShowRepo

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Results<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var tvShowsPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        mViewModel = (TvShowsViewModel(repo))
    }

    @Test
    fun testDoGetDiscoverTvShow() {

        val dummyTvShows = Results.success(tvShowsPagedList)
        `when`(dummyTvShows.data?.size).thenReturn(10)

        val tvShows = MutableLiveData<Results<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShows

        `when`(repo.getDiscoverTvShow()).thenReturn(tvShows)
        val tvShowEntity = mViewModel.doGetDiscoverTvShow().value?.data
        verify(repo).getDiscoverTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(10, tvShowEntity?.size)

        mViewModel.doGetDiscoverTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)

    }

}