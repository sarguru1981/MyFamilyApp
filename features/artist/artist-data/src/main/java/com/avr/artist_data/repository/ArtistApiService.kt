package com.avr.artist_data.repository


import com.avr.artist_domain.entities.ArtistList
import com.avr.network.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ArtistApiService {

    @GET("person/popular")
    fun getArtistList(
        @Query(
            "api_key"
        ) apiKey: String = BuildConfig.API_KEY
    ): Single<ArtistList>
}
