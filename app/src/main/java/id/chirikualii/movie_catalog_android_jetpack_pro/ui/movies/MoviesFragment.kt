package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.vo.Status
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentMoviesBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailMovies.DetailMoviesActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.MarginItemDecoration
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

@AndroidEntryPoint
class MoviesFragment : Fragment(), OnItemClicked {

    private lateinit var binding: FragmentMoviesBinding
    private lateinit var movieListAdapter: MoviesListAdapter

    private val mViewModel: MoviesViewModel by lazy {
        ViewModelProvider(this).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()

        mViewModel.doGetDiscoverMovieApi().observe(viewLifecycleOwner, { result ->
            if(result !=null){
                when(result.status){
                    Status.LOADING -> {
                        binding.progressBarMovies.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.progressBarMovies.visibility = View.INVISIBLE
                        binding.recyclerViewMovie.adapter?.let {  adapter ->
                            when(adapter){
                                is MoviesListAdapter -> {
                                    adapter.submitList(result.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }

                        }

                    }
                    Status.ERROR -> {
                        binding.progressBarMovies.visibility = View.INVISIBLE

                    }
                }
            }

        })

    }

    private fun setupView() {

        binding.recyclerViewMovie.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))
            adapter =  MoviesListAdapter(this@MoviesFragment)
        }

    }

    override fun onMovieClicked(data: MovieEntity?) {
        super.onMovieClicked(data)
        val intent = Intent(requireContext(), DetailMoviesActivity::class.java)
        intent.putExtra("MOVIE_ID", data?.movieId.toString())
        requireContext().startActivity(intent)
    }
}