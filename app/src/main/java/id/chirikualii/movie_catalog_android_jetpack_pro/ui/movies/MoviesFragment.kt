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

        movieListAdapter = MoviesListAdapter(this)
        movieListAdapter.addList(mViewModel.doGetDiscoverMovie())
        setupView()

    }

    private fun setupView() {

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))
            adapter = movieListAdapter
        }


    }

    override fun onMovieClicked(data: Movie) {
        super.onMovieClicked(data)
        val intent = Intent(requireContext(), DetailMoviesActivity::class.java)
        intent.putExtra("MOVIE_ID", data.id)
        requireContext().startActivity(intent)
    }
}