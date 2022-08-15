package com.avr.artist_data.repository


import com.avr.artist_data.BuildConfig
import com.avr.artist_domain.entities.Artist
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApiService {

    @GET("person/popular")
    fun getPopularArtistList(
        @Query(
            "api_key"
        ) apiKey: String = BuildConfig.API_KEY
    ): Single<List<Artist>>
}