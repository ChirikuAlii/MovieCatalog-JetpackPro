package id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.movieFavorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.R
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Status
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentMovieFavoriteBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies.DetailMoviesActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.favorite.FavoriteViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies.MoviesListAdapter
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows.TvShowsViewModel
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

@AndroidEntryPoint
class MovieFavoriteFragment : Fragment() , OnItemClicked{

    lateinit var binding : FragmentMovieFavoriteBinding

    val  mViewModel: FavoriteViewModel by lazy {
        ViewModelProvider(requireActivity()).get(FavoriteViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieFavoriteBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

        mViewModel.doGetMoviesFavorite().observe(viewLifecycleOwner,{ data ->

            binding.recyclerViewMovieFavorite.adapter?.let {  adapter ->
                when(adapter){
                    is MoviesListAdapter -> {
                        if(data.isNullOrEmpty()){
                            binding.tvEmptyMovieFavorite.visibility = View.VISIBLE
                            binding.recyclerViewMovieFavorite.visibility = View.INVISIBLE
                        }else{
                            binding.tvEmptyMovieFavorite.visibility = View.INVISIBLE
                            binding.recyclerViewMovieFavorite.visibility = View.VISIBLE
                            adapter.submitList(data)
                            adapter.notifyDataSetChanged()
                        }

                    }
                }

            }

        })
    }

    private fun setupView() {
        binding.recyclerViewMovieFavorite.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MoviesListAdapter(this@MovieFavoriteFragment)
        }
    }

    override fun onMovieClicked(data: MovieEntity?) {
        super.onMovieClicked(data)
        val intent = Intent(requireContext(), DetailMoviesActivity::class.java)
        intent.putExtra("MOVIE_ID", data?.movieId.toString())
        requireContext().startActivity(intent)
    }

}