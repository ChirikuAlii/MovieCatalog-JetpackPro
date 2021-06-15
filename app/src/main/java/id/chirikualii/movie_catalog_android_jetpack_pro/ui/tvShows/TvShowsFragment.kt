package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentTvShowsBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast

@AndroidEntryPoint
class TvShowsFragment : Fragment() ,Observer<TvShowsViewModel.TvShowsState>{

    private lateinit var binding : FragmentTvShowsBinding

    private val mViewModel :TvShowsViewModel by lazy {
        ViewModelProvider(this).get(TvShowsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.state.observe(viewLifecycleOwner,this)
        mViewModel.doGetDiscoverTvShow()
    }

    override fun onChanged(state: TvShowsViewModel.TvShowsState?) {

        when(state){

            is TvShowsViewModel.TvShowsState.Success -> {

                requireContext().toast("sukses tv show")
            }

            is TvShowsViewModel.TvShowsState.Failed -> {
                requireContext().toast("gagal tv show")
            }

            is TvShowsViewModel.TvShowsState.Loading -> {
                //loading
            }
        }
    }

}