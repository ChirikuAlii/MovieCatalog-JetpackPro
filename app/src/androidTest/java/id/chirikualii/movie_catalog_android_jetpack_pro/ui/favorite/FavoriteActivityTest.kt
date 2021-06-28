package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
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
        onView(ViewMatchers.withId(R.id.viewPagerFavorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeLeft())

        onView(ViewMatchers.withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeRight())
    }

    @Test
    fun loadMoviesFavorite() {
        onView(ViewMatchers.withId(R.id.viewPagerFavorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(ViewMatchers.withId(R.id.recyclerViewMovieFavorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loadTvShowFavorite() {

        onView(ViewMatchers.withId(R.id.viewPagerFavorite))
            .perform(ViewActions.swipeLeft())

        onView(ViewMatchers.withId(R.id.recyclerViewTVShowFavorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}
