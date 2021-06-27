package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.tvShowFavorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentTvShowFavoriteBinding

class TvShowFavoriteFragment : Fragment() {

    lateinit var binding : FragmentTvShowFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

}