package id.chirikualii.movie_catalog_android_jetpack_pro.ui.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ItemListFilmBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

class TvShowsListAdapter(private val onItemClicked: OnItemClicked) :
    PagedListAdapter<TvShowEntity,TvShowsListAdapter.TvShowHolder>(DIFF_CALLBACK) {

    inner class TvShowHolder(val binding: ItemListFilmBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val binding =
            ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) {
        val data = getItem(position)
        with(holder) {

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w185${data?.poster}")
                .transform(RoundedCorners(8))
                .into(binding.ivPoster)

            binding.tvDescFilm.text = data?.desc
            binding.tvTitleFilm.text = data?.title

            itemView.setOnClickListener {
                onItemClicked.onTvShowClicked(data)
            }
        }
    }

}