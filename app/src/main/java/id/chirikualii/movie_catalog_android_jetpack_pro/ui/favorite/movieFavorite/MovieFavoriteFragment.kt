package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.movieFavorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentMovieFavoriteBinding

class MovieFavoriteFragment : Fragment() {

    lateinit var binding : FragmentMovieFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieFavoriteBinding.inflate(inflater,container,false)

        return binding.root
    }

}