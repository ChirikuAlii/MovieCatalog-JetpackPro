package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentMoviesBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.main.MainViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

@AndroidEntryPoint
class MoviesFragment : Fragment() , Observer<MoviesViewModel.MoviesState> {

    private lateinit var binding : FragmentMoviesBinding
    private val mViewModel : MoviesViewModel by lazy {
        ViewModelProvider(this).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.state.observe(viewLifecycleOwner,this)
        mViewModel.doGetDiscoverMovie()
    }

    override fun onChanged(state: MoviesViewModel.MoviesState?) {

        when(state){

            is MoviesViewModel.MoviesState.Success -> {

                requireContext().toast("sukses")
            }

            is MoviesViewModel.MoviesState.Failed -> {
                requireContext().toast("gagal")
            }

            is MoviesViewModel.MoviesState.Loading -> {
                //loading
            }
        }
    }
}