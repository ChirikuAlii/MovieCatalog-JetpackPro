package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailTvShowsBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

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


        mViewModel.doLoadDetailTvShow(tvShowId).observe(this, { data ->
            binding.tvTitleTv.text = data.title
            binding.tvDescTv.text = data.desc
            binding.tvDateTv.text = data.releaseDate

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w185${data.poster}")
                .transform(RoundedCorners(8))
                .into(binding.ivPosterTv)

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500${data.backdrop}")
                .into(binding.ivBackdropTv)


            when(data.isFavorite){
                0 -> {
                    binding.fabFavoriteTvShow.setImageResource(R.drawable.ic_favorite_white)

                }
                1 -> {
                    binding.fabFavoriteTvShow.setImageResource(R.drawable.ic_favorite_red)
                }
            }

            binding.fabFavoriteTvShow.setOnClickListener {

                when(data.isFavorite){
                    0 -> {
                        toast("added to favorite")
                    }
                    1 -> {
                        toast("remove from favorite")

                    }
                }
                mViewModel.doUpdateDetailTvShow(data)

            }
        })

        
    }

}