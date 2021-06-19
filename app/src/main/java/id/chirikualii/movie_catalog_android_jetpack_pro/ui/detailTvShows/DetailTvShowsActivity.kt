package id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityDetailTvShowsBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

class DetailTvShowsActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailTvShowsBinding

    var tvShowId =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvShowId = intent.getStringExtra("TVSHOW_ID").toString()

        toast(tvShowId)

    }
}