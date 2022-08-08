package com.avr.data.repository

import com.avr.data.BuildConfig
import com.avr.data.model.tvshowdetail.TVShowDetailDTO
import com.avr.data.model.tvshowlist.TVShowListDTO
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVApiService {

    @GET("tv/popular")
    suspend fun getPopularTVShowList(
        @Query(
            "api_key"
        ) apiKey: String = BuildConfig.API_KEY
    ): Response<TVShowListDTO>

    @GET("tv/{id}")
    suspend fun getPopularTVShowDetail(
        @Path("id") id: String,
        @Query(
            "api_key"
        ) apiKey: String =BuildConfig.API_KEY
    ): Response<TVShowDetailDTO>
}