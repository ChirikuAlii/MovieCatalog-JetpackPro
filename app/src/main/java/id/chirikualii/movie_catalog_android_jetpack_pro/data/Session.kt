package id.chirikualii.movie_catalog_android_jetpack_pro.data

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */

class Session @Inject constructor(context: Context, val gson: Gson) {

    private val sp = context.getSharedPreferences(SESSION_NAME, Context.MODE_PRIVATE)
    private val spe = sp.edit()

    companion object {
        private const val SESSION_NAME = "MovieCatalogSession"
        private const val LOGIN_PREF = "LOGIN STATE"
    }

    fun reset() {
        spe.clear().apply()
    }

    var isLogin: Boolean
        get() = sp.getBoolean(LOGIN_PREF, false)
        set(value) {
            spe.putBoolean(LOGIN_PREF, value)
            spe.apply()
        }

}