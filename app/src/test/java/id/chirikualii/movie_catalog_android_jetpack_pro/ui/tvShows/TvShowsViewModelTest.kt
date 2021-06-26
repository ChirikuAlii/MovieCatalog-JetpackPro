package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import junit.framework.Assert.assertEquals
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

    private val dummyTvShow = DataDummy.getTvShows()
    private lateinit var mViewModel: TvShowsViewModel

    @Mock
    private lateinit var repo: TvShowRepo

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer : Observer<ArrayList<TvShow>>
    @Before
    fun setUp() {
        mViewModel = (TvShowsViewModel(repo))
    }

    @Test
    fun testDoGetDiscoverTvShow() {
        val tvShows = MutableLiveData<ArrayList<TvShow>>()
        val arrayList = arrayListOf<TvShow>()
        arrayList.addAll(dummyTvShow)
        tvShows.value = arrayList

        `when`(repo.getDiscoverTvShowsApi()).thenReturn(tvShows)

        val dataListTvShow = mViewModel.doGetDiscoverTvShow().value

        verify(repo).getDiscoverTvShowsApi()
        assertNotNull(dataListTvShow)
        assertEquals(10, dataListTvShow?.size)

        mViewModel.doGetDiscoverTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(arrayList)
    }

}