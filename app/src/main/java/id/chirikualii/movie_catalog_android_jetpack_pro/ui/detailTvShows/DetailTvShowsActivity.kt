package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailTvShowsBinding

@AndroidEntryPoint
class DetailTvShowsActivity : AppCompatActivity() {

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

        mViewModel.setSelectedTvShow(tvShowId)
        val data = mViewModel.doLoadDetailTvShow()

        binding.tvTitleTv.text = data.title
        binding.tvDescTv.text = data.overview
        binding.tvDateTv.text = data.releaseDate

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${data.poster}")
            .transform(RoundedCorners(8))
            .into(binding.ivPosterTv)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${data.backdrop}")
            .into(binding.ivBackdropTv)
    }

}