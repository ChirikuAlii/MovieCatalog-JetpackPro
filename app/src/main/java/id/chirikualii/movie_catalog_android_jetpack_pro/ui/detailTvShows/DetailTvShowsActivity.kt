package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailTvShowsBinding

@AndroidEntryPoint
class DetailTvShowsActivity : AppCompatActivity(),
    Observer<DetailTvShowViewModel.DetailTvShowsState> {

    lateinit var binding: ActivityDetailTvShowsBinding
    val mViewModel: DetailTvShowViewModel by lazy {
        ViewModelProvider(this).get(DetailTvShowViewModel::class.java)
    }
    var tvShowId = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvShowId = intent.getStringExtra("TVSHOW_ID").toString()
        mViewModel.state.observe(this, this)

        mViewModel.doLoadDetailMovie(tvShowId)

    }

    override fun onChanged(state: DetailTvShowViewModel.DetailTvShowsState?) {

        when (state) {

            is DetailTvShowViewModel.DetailTvShowsState.Success -> {

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

            is DetailTvShowViewModel.DetailTvShowsState.Failed -> {

            }

            is DetailTvShowViewModel.DetailTvShowsState.Loading -> {

            }
        }
    }
}