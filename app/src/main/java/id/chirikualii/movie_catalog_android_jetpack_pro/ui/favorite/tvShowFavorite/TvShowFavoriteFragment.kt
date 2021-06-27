package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.tvShowFavorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentTvShowFavoriteBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows.DetailTvShowsActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.FavoriteViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesListAdapter
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsListAdapter
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

class TvShowFavoriteFragment : Fragment(), OnItemClicked {

    lateinit var binding : FragmentTvShowFavoriteBinding

    val  mViewModel: FavoriteViewModel by lazy {
        ViewModelProvider(requireActivity()).get(FavoriteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowFavoriteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

        mViewModel.doGetTvShowsFavorite().observe(viewLifecycleOwner,{ data ->

            binding.recyclerViewTVShowFavorite.adapter?.let {  adapter ->
                when(adapter){
                    is TvShowsListAdapter -> {
                        if(data.isNullOrEmpty()){
                            binding.tvEmptyTvShowFavorite.visibility = View.VISIBLE
                            binding.recyclerViewTVShowFavorite.visibility = View.INVISIBLE
                        }else{
                            binding.tvEmptyTvShowFavorite.visibility = View.INVISIBLE
                            binding.recyclerViewTVShowFavorite.visibility = View.VISIBLE
                            adapter.submitList(data)
                            adapter.notifyDataSetChanged()
                        }

                    }
                }

            }
        })
    }

    private fun setupView() {
        binding.recyclerViewTVShowFavorite.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvShowsListAdapter(this@TvShowFavoriteFragment)
        }
    }

    override fun onTvShowClicked(data: TvShowEntity?) {
        super.onTvShowClicked(data)
        val intent = Intent(requireContext(), DetailTvShowsActivity::class.java)
        intent.putExtra("TVSHOW_ID", data?.tvShowId.toString())
        requireContext().startActivity(intent)
    }
}