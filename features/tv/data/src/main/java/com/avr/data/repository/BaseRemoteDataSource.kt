package com.avr.data.repository

import com.avr.domain.base.ApiError
import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

/**
 * Base class of Remote API Data source
 * @param retrofit the object of Retrofit instance
 */
abstract class BaseRemoteDataSource constructor(
    private val retrofit: Retrofit
) {

    /**
     * Method to parse the Response of API Service
     * @param T the type of Response
     * @param request
     * @return Output<T> the result of the request with type T
     */
    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): Output<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Output.success(result.body())
            } else {
                val errorResponse = parseError(result)
                Output.error(errorResponse?.statusMessage ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Output.error("Unknown Error", null)
        }
    }

    suspend fun <T> getObjectResponse(
        request: suspend () -> T,
        defaultErrorMessage: String
    ): Output<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result != null) {
                return Output.success(result)
            } else {
                Output.error(defaultErrorMessage, null)
            }
        } catch (e: Throwable) {
            Output.error("Unknown Error", null)
        }
    }

    suspend fun <T> getListResponse(
        request: suspend () -> List<T>
    ): Output<List<T>> {
        return try {
            val result = request.invoke()
            if(result.isNotEmpty()){
                return Output.success(result)
            } else {
                Output.error("Parsing Error", null)
            }
        } catch (e: Throwable) {
            Output.error("Unknown Error", null)
        }
    }

    /**
     * Method to convert the error response of API Service to requested type
     * @param response the response of requested api
     * @return the ApiError of the request
     */
    private fun parseError(response: Response<*>): ApiError? {
        val converter =
            retrofit.responseBodyConverter<ApiError>(ApiError::class.java, arrayOfNulls(0))
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            }
        } catch (e: IOException) {
            ApiError()
        }
    }
}