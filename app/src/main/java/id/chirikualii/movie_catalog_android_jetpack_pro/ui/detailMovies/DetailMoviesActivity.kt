package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailMoviesBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

class DetailMoviesActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailMoviesBinding

    var movieId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieId = intent.getStringExtra("MOVIE_ID").toString()

        toast(movieId)

    }
}