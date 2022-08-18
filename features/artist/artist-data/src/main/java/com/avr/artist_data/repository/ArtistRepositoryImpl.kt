package com.avr.artist_data.repository

import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_domain.entities.ArtistList
import com.avr.artist_domain.repository.ArtistRepository
import io.reactivex.Single


class ArtistRepositoryImpl(
    private val artistListRemoteDataSource: ArtistListRemoteDataSource
) : ArtistRepository {

    override fun getArtistList(): Single<ArtistList> {
        return artistListRemoteDataSource.getArtistListFromRemote()
    }
}
