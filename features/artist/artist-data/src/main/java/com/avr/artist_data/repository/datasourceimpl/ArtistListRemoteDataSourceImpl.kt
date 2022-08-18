package com.avr.artist_data.repository.datasourceimpl

import com.avr.artist_data.repository.ArtistApiService
import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_domain.entities.ArtistList
import io.reactivex.Single
import javax.inject.Inject

class ArtistListRemoteDataSourceImpl @Inject constructor(
    private val artistApiService: ArtistApiService
) : ArtistListRemoteDataSource {

    override fun getArtistListFromRemote(): Single<ArtistList> {
        return artistApiService.getArtistList()
    }
}