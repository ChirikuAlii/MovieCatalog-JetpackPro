package id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */

@Entity(tableName = "tv_show")
@Parcelize
data class TvShowEntity(

    @PrimaryKey
    @ColumnInfo(name = "tv_show_id")
    var tvShowId: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "desc")
    var desc: String? = null,

    @ColumnInfo(name = "release_date")
    var releaseDate: String? =null,

    @ColumnInfo(name = "poster_path")
    var poster: String? = null,

    @ColumnInfo(name = "backdrop_path")
    var backdrop: String? = null,

    @NonNull
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Int = 0
): Parcelable