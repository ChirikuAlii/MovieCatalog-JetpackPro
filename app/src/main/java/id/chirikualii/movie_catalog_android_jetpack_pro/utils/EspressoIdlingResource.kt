package id.chirikualii.movie_catalog_android_jetpack_pro.utils

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Create by Chiriku Alii on 6/24/21
 * github.com/chirikualii
 */
object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        countingIdlingResource.increment()
    }
    fun decrement(){
        if(!countingIdlingResource.isIdleNow){
            countingIdlingResource.decrement()
        }

    }
}