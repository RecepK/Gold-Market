package com.kurban.goldmarket.common


sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>() : Resource<T>()
    data class Success<T>(val value: T?) : Resource<T>(data = value)
    data class Error<T>(val error: String?) : Resource<T>(message = error)
}