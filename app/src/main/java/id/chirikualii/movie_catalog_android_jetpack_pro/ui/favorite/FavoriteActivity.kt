package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityFavoriteBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.movieFavorite.MovieFavoriteFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.tvShowFavorite.TvShowFavoriteFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.main.TabAdapter
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsViewModel

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {

    private val movieFragment = MovieFavoriteFragment()
    private val tvShowFragment = TvShowFavoriteFragment()
    private val listFragment = listOf<Fragment>(movieFragment, tvShowFragment)
    private val tabAdapter = TabAdapter(listFragment, this)
    private lateinit var tabLayoutMediator: TabLayoutMediator

    lateinit var binding : ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {

        binding.viewPagerFavorite.adapter = tabAdapter

        tabLayoutMediator = TabLayoutMediator(
            binding.tabLayoutFavorite,
            binding.viewPagerFavorite
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Movie"
                1 -> tab.text = "Tv Show"
            }

        }.also { it.attach() }

    }
}