package id.chirikualii.movie_catalog_android_jetpack_pro.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun ImageView.loadFromUrl(path: String) {
    Glide.with(this).clear(this)
    Glide.with(this)
        .setDefaultRequestOptions(
            RequestOptions()
            //.placeholder(R.drawable.image_placeholder)
            // .error(R.drawable.image_placeholder)
        ).load(path).into(this)
}