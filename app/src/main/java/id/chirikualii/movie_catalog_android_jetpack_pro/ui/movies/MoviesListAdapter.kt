package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ItemListFilmBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.loadFromUrl
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

class MoviesListAdapter(private val onItemClicked: OnItemClicked) :
    PagedListAdapter<MovieEntity,MoviesListAdapter.MovieHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MovieHolder(val binding: ItemListFilmBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(data:MovieEntity){
              
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w185${data?.poster}")
                .transform(RoundedCorners(8))
                .into(binding.ivPoster)

                binding.tvDescFilm.text = data?.desc
                binding.tvTitleFilm.text = data?.title

                itemView.setOnClickListener {
                    onItemClicked.onMovieClicked(data)

                }

            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding =
            ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val data = getItem(position)
        if(data!=null){
            holder.bind(data)
        }
    }
}