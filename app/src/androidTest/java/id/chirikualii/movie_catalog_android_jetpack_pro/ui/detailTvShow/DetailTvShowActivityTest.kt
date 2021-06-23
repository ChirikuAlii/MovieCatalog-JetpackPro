package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShow

import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows.DetailTvShowsActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Create by Chiriku Alii on 6/23/21
 * github.com/chirikualii
 */
class DetailTvShowActivityTest {

    private val dummyTvShow = DataDummy.getTvShows()[1]

    private var context: Context? = null


    @Rule
    @JvmField
    var activityTestRule: ActivityTestRule<DetailTvShowsActivity> =
        object : ActivityTestRule<DetailTvShowsActivity>(
            DetailTvShowsActivity::class.java
        ) {
            override fun getActivityIntent(): Intent {
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().getTargetContext()
                val result = Intent(targetContext, DetailTvShowsActivity::class.java)
                result.putExtra("TVSHOW_ID", dummyTvShow.id)
                return result
            }
        }

    @Before
    fun setUp() {
        context = activityTestRule.activity.applicationContext
    }
    
    @Test
    fun detailTvShow(){
        onView(ViewMatchers.withId(R.id.tvTitleTv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tvDateTv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tvDescTv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.ivBackdropTv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.ivPosterTv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        onView(ViewMatchers.withId(R.id.tvTitleTv))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.title)))
        onView(ViewMatchers.withId(R.id.tvDateTv))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.releaseDate)))
        onView(ViewMatchers.withId(R.id.tvDescTv))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.overview)))
    }
}