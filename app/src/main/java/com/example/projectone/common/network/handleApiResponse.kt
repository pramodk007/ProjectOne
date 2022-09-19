package com.example.projectone.common.network

import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApiResponse(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            ApiResult.Success(body)
        } else {
            ApiResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        ApiResult.Error(code = e.code(), message = e.message())
    } catch (e: ApiException) {
        ApiResult.Exception(e)
    } catch (e: NoInternetException) {
        ApiResult.Exception(e)
    } catch (e: Throwable) {
        ApiResult.Exception(e)
    }
}