package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ItemListFilmBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

class TvShowsListAdapter(private val onItemClicked: OnItemClicked) :
    RecyclerView.Adapter<TvShowsListAdapter.TvShowHolder>() {

    private var listDataFiltered = ArrayList<TvShow>()

    inner class TvShowHolder(val binding: ItemListFilmBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun addList(listData: ArrayList<TvShow>) {
        listDataFiltered = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val binding =
            ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        val data = listDataFiltered[position]
        with(holder) {

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${data.poster}")
                .transform(RoundedCorners(8))
                .into(binding.ivPoster)

            binding.tvDescFilm.text = data.overview
            binding.tvTitleFilm.text = data.title

            itemView.setOnClickListener {
                onItemClicked.onTvShowClicked(data)
            }
        }
    }

    override fun getItemCount(): Int {
        return listDataFiltered.size
    }
}