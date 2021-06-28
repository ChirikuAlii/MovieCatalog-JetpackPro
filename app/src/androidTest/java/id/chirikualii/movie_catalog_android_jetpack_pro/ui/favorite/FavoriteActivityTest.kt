package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Create by Chiriku Alii on 6/28/21
 * github.com/chirikualii
 */

class FavoriteActivityTest {

    @Rule
    @JvmField
    var activityTestRule: ActivityTestRule<FavoriteActivity> =
        ActivityTestRule(FavoriteActivity::class.java)
    lateinit var activity: FavoriteActivity

    @Before
    fun setUp() {
        activity = activityTestRule.activity
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
        activityTestRule.launchActivity(Intent())
        ViewMatchers.assertThat(activityTestRule, Matchers.notNullValue())

    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun swipePageFavorite() {
        onView(withId(R.id.viewPagerFavorite))
            .check(matches(isDisplayed()))

        onView(withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeLeft())

        onView(withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeRight())
    }

    @Test
    fun loadMoviesFavorite() {
        onView(withId(R.id.viewPagerFavorite))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovieFavorite))
            .check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShowFavorite() {

        onView(withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeLeft())

        onView(withId(R.id.recyclerViewTVShowFavorite))
            .check(matches(isDisplayed()))

    }
}
