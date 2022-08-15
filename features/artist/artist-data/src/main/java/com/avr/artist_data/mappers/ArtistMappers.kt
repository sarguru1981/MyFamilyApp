package com.avr.artist_data.mappers

import com.avr.artist_data.model.ArtistDTO
import com.avr.artist_domain.entities.Artist

fun List<ArtistDTO>.toDomain(): List<Artist> {
    return map {
        Artist(
            id = it.id ?: 0,
            adult = it.adult ?: false,
            gender = it.gender ?: 1,
            known_for_department = it.known_for_department ?: "",
            name = it.name ?: "",
            popularity = it.popularity ?: 0.0,
            profile_path = it.profile_path ?: "",
        )
    }
}