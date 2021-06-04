package id.chirikualii.movie_catalog_android_jetpack_pro.data.vo

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */

sealed class Results<out R> {
    data class Success<out T>(val data: T): Results<T>()
    data class Error(
        val cause: RequestResult = RequestResult.NOT_DEFINED,
        val exception: Throwable
    ): Results<Nothing>()
    object Loading: Results<Nothing>()
}