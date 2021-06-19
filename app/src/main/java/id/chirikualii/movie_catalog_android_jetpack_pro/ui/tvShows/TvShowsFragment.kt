package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentTvShowsBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies.DetailMoviesActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows.DetailTvShowsActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.MarginItemDecoration
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

@AndroidEntryPoint
class TvShowsFragment : Fragment() ,Observer<TvShowsViewModel.TvShowsState>, OnItemClicked{

    private lateinit var binding : FragmentTvShowsBinding
    private lateinit var adapterList: TvShowsListAdapter

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

        adapterList = TvShowsListAdapter(this)

        setupView()
    }

    private fun setupView() {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))
            adapter = adapterList

        }

    }

    override fun onChanged(state: TvShowsViewModel.TvShowsState?) {

        when(state){

            is TvShowsViewModel.TvShowsState.Success -> {
                adapterList.addList(state.data)

            }

            is TvShowsViewModel.TvShowsState.Failed -> {

            }

            is TvShowsViewModel.TvShowsState.Loading -> {
                //loading
            }
        }
    }

    override fun onTvShowClicked(data: TvShow) {
        super.onTvShowClicked(data)
        val intent = Intent(requireContext(), DetailTvShowsActivity::class.java)
        intent.putExtra("TVSHOW_ID",data.id)
        requireContext().startActivity(intent)
    }

}