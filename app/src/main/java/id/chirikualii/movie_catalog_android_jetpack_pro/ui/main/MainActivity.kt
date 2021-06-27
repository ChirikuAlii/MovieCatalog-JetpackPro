package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityMainBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.FavoriteActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieFragment = MoviesFragment()
    private val tvShowFragment = TvShowsFragment()
    private val listFragment = listOf<Fragment>(movieFragment, tvShowFragment)
    private val tabAdapter = TabAdapter(listFragment, this)
    private lateinit var tabLayoutMediator: TabLayoutMediator

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {

        binding.viewPager.adapter = tabAdapter

        tabLayoutMediator = TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {
                0 -> tab.text = "Movie"
                1 -> tab.text = "Tv Shows"
            }

        }.also { it.attach() }

        binding.btnFavorite.setOnClickListener {
            startActivity(Intent(this,FavoriteActivity::class.java))
        }
    }
}