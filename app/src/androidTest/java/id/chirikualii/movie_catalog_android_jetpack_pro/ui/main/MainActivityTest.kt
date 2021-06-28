package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.EspressoIdlingResource
import org.hamcrest.Matchers.notNullValue
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    fun test1swipePage() {
        onView(withId(R.id.viewPager))
            .check(matches(isDisplayed()))

        onView(withId(R.id.viewPager))
            .perform(swipeLeft())

        onView(withId(R.id.viewPager))
            .perform(swipeRight())
    }

    @Test
    fun test2loadMovies() {
        onView(withId(R.id.viewPager))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))
    }

    @Test
    fun test3loadTvShow() {

        onView(withId(R.id.viewPager))
            .perform(swipeLeft())

        onView(withId(R.id.recyclerViewTVShow))
            .check(matches(isDisplayed()))

        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(9))
    }

    @Test
    fun test4DetailMovie() {
        onView(withId(R.id.recyclerViewMovie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewMovie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        onView(withId(R.id.recyclerViewMovie))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                    ViewActions.click()
                ))

        onView(withId(R.id.ivPoster))
            .check(matches(isDisplayed()))
        onView(withId(R.id.ivBackdrop))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvDesc))
            .check(matches(isDisplayed()))

        onView(withId(R.id.fabFavoriteMovie)).perform(ViewActions.click())
        onView(withId(R.id.fabFavoriteMovie)).perform(ViewActions.click())

        Espresso.pressBack()
    }

    @Test
    fun test5DetailTvShow() {

        onView(withText("TV SHOWS")).perform(ViewActions.click())
        onView(withId(R.id.recyclerViewTVShow))
            .check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewTVShow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        onView(withId(R.id.recyclerViewTVShow))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                    ViewActions.click()
                ))

        onView(withId(R.id.ivPosterTv))
            .check(matches(isDisplayed()))
        onView(withId(R.id.ivBackdropTv))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvTitleTv))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tvDescTv))
            .check(matches(isDisplayed()))

        onView(withId(R.id.fabFavoriteTvShow)).perform(ViewActions.click())
        onView(withId(R.id.fabFavoriteTvShow)).perform(ViewActions.click())

        Espresso.pressBack()
    }

}
