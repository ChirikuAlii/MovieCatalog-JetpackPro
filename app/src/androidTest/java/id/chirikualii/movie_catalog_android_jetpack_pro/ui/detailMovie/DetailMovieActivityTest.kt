package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovie

import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies.DetailMoviesActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Create by Chiriku Alii on 6/23/21
 * github.com/chirikualii
 */

class DetailMovieActivityTest {

    private val dummyMovie = DataDummy.getMovieList()[2]

    private var context: Context? = null

    @Rule
    @JvmField
    var activityTestRule: ActivityTestRule<DetailMoviesActivity> =
        object : ActivityTestRule<DetailMoviesActivity>(
            DetailMoviesActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().getTargetContext()
                val result = Intent(targetContext, DetailMoviesActivity::class.java)
                result.putExtra("MOVIE_ID", dummyMovie.id)
                return result
            }
        }

    @Before
    fun setUp() {
        context = activityTestRule.activity.applicationContext
    }

    @Test
    fun detailMovie(){

        onView(ViewMatchers.withId(R.id.tvTitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tvDate))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tvDesc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.ivBackdrop))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.ivPoster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        onView(ViewMatchers.withId(R.id.tvTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie.title)))
        onView(ViewMatchers.withId(R.id.tvDate))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie.releaseDate)))
        onView(ViewMatchers.withId(R.id.tvDesc))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie.overview)))
    }
}