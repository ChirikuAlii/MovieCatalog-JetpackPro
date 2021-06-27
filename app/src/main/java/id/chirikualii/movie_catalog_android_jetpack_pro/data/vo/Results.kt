package id.chirikualii.movie_catalog_android_jetpack_pro.data.vo

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */


data class Results<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Results<T> = Results(Status.SUCCESS, data, null)

        fun <T> error(msg: String?, data: T?): Results<T> = Results(Status.ERROR, data, msg)

        fun <T> loading(data: T?): Results<T> = Results(Status.LOADING, data, null)
    }
}

enum class Status {
    SUCCESS,
    LOADING,
    ERROR,

}