package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.MovieRepo
import id.chirikualii.movie_catalog_android_jetpack_pro.data.repository.TvShowRepo
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

/**
 * Create by Chiriku Alii on 6/28/21
 * github.com/chirikualii
 */


@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    private lateinit var mViewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepo: MovieRepo

    @Mock
    private lateinit var tvShowRepo: TvShowRepo

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        mViewModel = FavoriteViewModel(movieRepo,tvShowRepo)
    }

    @Test
    fun getListFavoriteMovie() {

        val dummyMovie = moviePagedList
        `when`(dummyMovie.size).thenReturn(3)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieRepo.getFavoriteMovies()).thenReturn(movie)
        val movieEntity = mViewModel.doGetMoviesFavorite().value
        verify(movieRepo).getFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(3, movieEntity?.size)

        mViewModel.doGetMoviesFavorite().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)

    }

    @Test
    fun getListFavoriteTvShow() {
        val dummyTvShow = tvShowPagedList
        `when`(dummyTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(tvShowRepo.getFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = mViewModel.doGetTvShowsFavorite().value
        verify(tvShowRepo).getFavoriteTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        mViewModel.doGetTvShowsFavorite().observeForever(observerTvShow)
        verify(observerTvShow).onChanged(dummyTvShow)
    }
}