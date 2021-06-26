package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
import org.hamcrest.Matchers.notNullValue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {


    @Rule
    @JvmField
    var activityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)
    lateinit var activity: MainActivity

    @Before
    fun setUp() {
        activity = activityTestRule.activity
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
        activityTestRule.launchActivity(Intent())
        assertThat(activityTestRule, notNullValue())

    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun swipePage() {
        onView(withId(R.id.viewPager))
            .check(matches(isDisplayed()))

        onView(withId(R.id.viewPager))
            .perform(swipeLeft())

        onView(withId(R.id.viewPager))
            .perform(swipeRight())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.viewPager))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))
    }

    @Test
    fun loadTvShow() {

        onView(withId(R.id.viewPager))
            .perform(swipeLeft())

        onView(withId(R.id.recyclerViewTVShow))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7))
    }

}
