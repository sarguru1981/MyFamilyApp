package com.avr.artist_data.repository.datasourceimpl

import com.avr.artist_data.repository.ArtistApiService
import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_domain.entities.Artist
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import javax.inject.Inject

class ArtistListRemoteDataSourceImpl @Inject constructor(
    private val apiService: ArtistApiService,
    retrofit: Retrofit
) : ArtistListRemoteDataSource {

    override fun getPopularArtistsFromRemote(): Single<List<Artist>> {
        return apiService.getPopularArtistList()
    }
}