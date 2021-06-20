package id.chirikualii.movie_catalog_android_jetpack_pro.ui.splash


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesListAdapter
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {

    private val dummyMovie = DataDummy.getMovieList()
    private val dummyTvShow = DataDummy.getTvShows()

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun loadMovieandTvShow(){


        onView(withId(R.id.recyclerViewMovie))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))

        onView(withId(R.id.viewPager)).perform(swipeLeft())

        onView(withId(R.id.recyclerViewTVShow))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))


        onView(withId(R.id.viewPager)).perform(swipeRight())




    }

    @Test
    fun detailMovie(){
        onView(withId(R.id.recyclerViewMovie))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(3))

        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieHolder>(3,click()))

        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc)).check(matches(isDisplayed()))
        onView(withId(R.id.ivBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.ivPoster)).check(matches(isDisplayed()))


        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[3].title)))
        onView(withId(R.id.tvDate)).check(matches(withText(dummyMovie[3].releaseDate)))
        onView(withId(R.id.tvDesc)).check(matches(withText(dummyMovie[3].overview)))
    }

    @Test
    fun detailTvShow(){
        onView(withId(R.id.viewPager)).perform(swipeLeft())

        onView(withId(R.id.recyclerViewTVShow))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))

        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MoviesListAdapter.MovieHolder>(2,click()))

        onView(withId(R.id.tvTitleTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDateTv)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescTv)).check(matches(isDisplayed()))
        onView(withId(R.id.ivBackdropTv)).check(matches(isDisplayed()))
        onView(withId(R.id.ivPosterTv)).check(matches(isDisplayed()))


        onView(withId(R.id.tvTitleTv)).check(matches(withText(dummyTvShow[2].title)))
        onView(withId(R.id.tvDateTv)).check(matches(withText(dummyTvShow[2].releaseDate)))
        onView(withId(R.id.tvDescTv)).check(matches(withText(dummyTvShow[2].overview)))
    }
}
