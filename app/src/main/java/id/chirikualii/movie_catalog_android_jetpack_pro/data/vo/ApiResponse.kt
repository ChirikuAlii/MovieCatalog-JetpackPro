package id.chirikualii.movie_catalog_android_jetpack_pro.data.vo

/**
 * Create by Chiriku Alii on 6/27/21
 * github.com/chirikualii
 */


class ApiResponse<T>(val status: StatusResponse, val body: T?, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

        fun <T> error(msg: String, body: T): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, body, msg)
    }
}

enum class StatusResponse {
    SUCCESS,
    ERROR
}