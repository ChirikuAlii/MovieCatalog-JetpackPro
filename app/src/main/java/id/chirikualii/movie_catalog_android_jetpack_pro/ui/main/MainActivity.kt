package id.chirikualii.movie_catalog_android_jetpack_pro.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ActivityMainBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Observer<MainViewModel.MainState> {

    val mViewModel : MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel.state.observe(this,this)
        mViewModel.doGetDiscoverMovie()

        //tab layout 2
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