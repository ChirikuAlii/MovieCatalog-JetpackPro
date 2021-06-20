package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailMoviesBinding

@AndroidEntryPoint
class DetailMoviesActivity : AppCompatActivity(),
    Observer<DetailMoviesViewModel.DetailMoviesState> {

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

        mViewModel.state.observe(this, this)
        mViewModel.doLoadDetailMovie(movieId)


    }

    override fun onChanged(state: DetailMoviesViewModel.DetailMoviesState?) {

        when (state) {

            is DetailMoviesViewModel.DetailMoviesState.Success -> {
                binding.tvTitle.text = state.data.title
                binding.tvDesc.text = state.data.overview
                binding.tvDate.text = state.data.releaseDate
                Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500${state.data.poster}")
                    .transform(RoundedCorners(8))
                    .into(binding.ivPoster)

                Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500${state.data.backdrop}")
                    .into(binding.ivBackdrop)
            }
            is DetailMoviesViewModel.DetailMoviesState.Failed -> {
            }
            is DetailMoviesViewModel.DetailMoviesState.Loading -> {
            }
        }
    }
}