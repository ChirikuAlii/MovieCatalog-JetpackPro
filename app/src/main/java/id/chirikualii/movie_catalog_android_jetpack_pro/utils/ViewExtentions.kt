package id.chirikualii.movie_catalog_android_jetpack_pro.utils

import android.content.Context
import android.widget.Toast

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}