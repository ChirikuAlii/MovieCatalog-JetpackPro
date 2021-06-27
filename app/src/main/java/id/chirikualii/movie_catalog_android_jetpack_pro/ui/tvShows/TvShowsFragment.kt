package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.FragmentTvShowsBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.ui.detailTvShows.DetailTvShowsActivity
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.MarginItemDecoration
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

@AndroidEntryPoint
class TvShowsFragment : Fragment(), OnItemClicked {

    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var adapterList: TvShowsListAdapter

    private val mViewModel: TvShowsViewModel by lazy {
        ViewModelProvider(this).get(TvShowsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterList = TvShowsListAdapter(this)
        setupView()

        mViewModel.doGetDiscoverTvShow().observe(viewLifecycleOwner, { tvShows ->
            adapterList.submitList(tvShows.data)
            binding.recyclerViewTVShow.adapter = adapterList
            adapterList.notifyDataSetChanged()
        })
    }

    private fun setupView() {

        binding.recyclerViewTVShow.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(MarginItemDecoration(16))

        }

    }

    override fun onTvShowClicked(data: TvShowEntity?) {
        super.onTvShowClicked(data)
        val intent = Intent(requireContext(), DetailTvShowsActivity::class.java)
        intent.putExtra("TVSHOW_ID", data?.tvShowId.toString())
        requireContext().startActivity(intent)
    }

}