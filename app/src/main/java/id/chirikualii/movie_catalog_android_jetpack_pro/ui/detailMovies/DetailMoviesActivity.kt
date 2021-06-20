package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailMoviesBinding

/**
 * Create by chirikualii on 6/10/21
 * github.com/chirikualii
 */

@AndroidEntryPoint
class DetailMoviesActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailMoviesBinding

    val mViewModel: DetailMoviesViewModel by lazy {
        ViewModelProvider(this).get(DetailMoviesViewModel::class.java)
    }

    var movieId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieId = intent.getStringExtra("MOVIE_ID").toString()

        mViewModel.setSelectedMovie(movieId)

        val data = mViewModel.doLoadDetailMovie()

        binding.tvTitle.text = data.title
        binding.tvDesc.text = data.overview
        binding.tvDate.text = data.releaseDate
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${data.poster}")
            .transform(RoundedCorners(8))
            .into(binding.ivPoster)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${data.backdrop}")
            .into(binding.ivBackdrop)

    }

}