package com.avr.artist_domain.repository

import com.avr.artist_domain.entities.ArtistList
import io.reactivex.Single


interface ArtistRepository {
    fun getArtistList(): Single<ArtistList>
}
