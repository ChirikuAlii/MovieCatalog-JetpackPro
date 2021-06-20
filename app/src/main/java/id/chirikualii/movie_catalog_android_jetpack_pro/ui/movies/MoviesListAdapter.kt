package id.chirikualii.movie_catalog_android_jetpack_pro.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import id.chirikualii.movie_catalog_android_jetpack_pro.databinding.ItemListFilmBinding
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.utils.view.OnItemClicked

class MoviesListAdapter(private val onItemClicked: OnItemClicked) :
    RecyclerView.Adapter<MoviesListAdapter.MovieHolder>() {

    private var listDataFiltered = ArrayList<Movie>()
    private var items: ArrayList<Movie> = ArrayList()

    inner class MovieHolder(val binding: ItemListFilmBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun addList(listData: ArrayList<Movie>) {
        items = listData
        listDataFiltered = listData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding =
            ItemListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val data = listDataFiltered[position]
        with(holder) {

            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w500${data.poster}")
                .transform(RoundedCorners(8))
                .into(binding.ivPoster)

            binding.tvDescFilm.text = data.overview
            binding.tvTitleFilm.text = data.title

            itemView.setOnClickListener {
                onItemClicked.onMovieClicked(data)

            }
        }
    }

    override fun getItemCount(): Int {
        return listDataFiltered.size
    }
}