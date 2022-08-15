package com.avr.artist_domain.repository

import com.avr.artist_domain.entities.Artist
import io.reactivex.rxjava3.core.Single

interface ArtistListRepository {

    fun getPopularArtist(): Single<List<Artist>>
}