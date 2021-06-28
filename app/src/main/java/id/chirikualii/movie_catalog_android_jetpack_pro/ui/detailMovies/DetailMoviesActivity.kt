package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailMoviesBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

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

        mViewModel.doLoadDetailMovie(movieId).observe(this, Observer { data ->

            binding.tvTitle.text = data?.title ?: ""
            binding.tvDesc.text = data?.desc ?: ""
            binding.tvDate.text = data?.releaseDate ?: ""
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w185${data?.poster ?: ""}")
                .transform(RoundedCorners(8))
                .into(binding.ivPoster)

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500${data?.backdrop ?: ""}")
                .into(binding.ivBackdrop)

            when(data?.isFavorite ?:0){
                0 -> {
                    binding.fabFavoriteMovie.setImageResource(R.drawable.ic_favorite_white)

                }
                1 -> {
                    binding.fabFavoriteMovie.setImageResource(R.drawable.ic_favorite_red)
                }
            }

            binding.fabFavoriteMovie.setOnClickListener {

                when(data?.isFavorite){
                    0 -> {
                        toast("added to favorite")
                    }
                    1 -> {
                        toast("remove from favorite")

                    }
                }
                mViewModel.doUpdateDetailMovie(data)

            }
        })



    }

}