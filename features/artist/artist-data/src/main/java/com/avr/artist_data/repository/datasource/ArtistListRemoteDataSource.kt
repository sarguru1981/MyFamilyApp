package com.avr.artist_data.repository.datasource

import com.avr.artist_domain.entities.ArtistList
import io.reactivex.Single


interface ArtistListRemoteDataSource {

    fun getArtistListFromRemote(): Single<ArtistList>
}