package com.avr.data.mappers

import com.avr.data.model.tvshowlist.TVShowItemDTO
import com.avr.domain.entities.tvshowlist.TVShowItem

fun List<TVShowItemDTO>.toDomain(): List<TVShowItem> {
    return map {
        TVShowItem(
            id = it.id ?: 0,
            backdrop_path = it.backdrop_path ?: "",
            first_air_date = it.first_air_date ?: "",
            genre_ids = it.genre_ids ?: emptyList(),
            name = it.name ?: "",
            origin_country = it.origin_country ?: emptyList(),
            original_language = it.original_language ?: "",
            original_name = it.original_name ?: "",
            overview = it.overview ?: "",
            popularity = it.popularity ?: 0.0,
            poster_path = it.poster_path ?: "",
            vote_average = it.vote_average ?: 0.0,
            vote_count = it.vote_count ?: 0
        )
    }
}