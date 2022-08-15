package com.avr.artist_data.repository.datasource

import com.avr.artist_domain.entities.Artist
import io.reactivex.rxjava3.core.Single

interface ArtistListRemoteDataSource {

    fun getPopularArtistsFromRemote(): Single<List<Artist>>
}