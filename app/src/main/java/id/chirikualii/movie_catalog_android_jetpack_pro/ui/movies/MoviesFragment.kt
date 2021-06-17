package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentMoviesBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.toast
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.MarginItemDecoration

@AndroidEntryPoint
class MoviesFragment : Fragment() , Observer<MoviesViewModel.MoviesState>, OnItemClicked {

    private lateinit var binding : FragmentMoviesBinding
    private lateinit var movieListAdapter : MoviesListAdapter
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

        movieListAdapter = MoviesListAdapter(this)

        setupView()

        mViewModel.doGetDiscoverMovie()
    }

    private fun setupView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addItemDecoration(MarginItemDecoration(16))
        binding.recyclerView.adapter = movieListAdapter

    }

    override fun onChanged(state: MoviesViewModel.MoviesState?) {

        when(state){

            is MoviesViewModel.MoviesState.Success -> {

                movieListAdapter.addList(state.data)
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