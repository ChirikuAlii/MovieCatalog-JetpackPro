package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityMainBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsFragment
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Observer<MainViewModel.MainState> {

    private val movieFragment = MoviesFragment()
    private val tvShowFragment = TvShowsFragment()
    private val listFragment = listOf(movieFragment,tvShowFragment)
    private val tabAdapter = TabAdapter(listFragment,this)
    private lateinit var tabLayoutMediator: TabLayoutMediator


    val mViewModel : MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        mViewModel.state.observe(this,this)
        mViewModel.doGetDiscoverMovie()
    }

    private fun setupView() {

        binding.viewPager.adapter = tabAdapter

        tabLayoutMediator = TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ){ tab,position ->

            when(position){
                0 -> tab.text ="Movie"
                1 -> tab.text ="Tv Shows"
            }

        }.also { it.attach() }
    }
    override fun onChanged(state: MainViewModel.MainState?) {

        when(state){

            is MainViewModel.MainState.Success -> {
                toast("sukses")
            }

            is MainViewModel.MainState.Failed -> {
                toast("gagal")
            }

            is MainViewModel.MainState.Loading -> {
                //loading
            }
        }
    }
}