package com.example.projectone.common.network

sealed class ApiResult<out T> {
    data class Success<T: Any>(val data: T) : ApiResult<T>()
    data class Error<T: Any>(val code: Int, val message: String?) : ApiResult<T>()
    data class Exception<T: Any>(val e: Throwable) : ApiResult<T>()
}
