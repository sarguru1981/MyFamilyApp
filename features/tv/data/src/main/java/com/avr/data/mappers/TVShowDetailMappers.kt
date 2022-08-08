package com.avr.data.mappers

import com.avr.data.model.tvshowdetail.TVShowDetailDTO
import com.avr.domain.entities.tvshowdetail.TVShowDetail

fun TVShowDetailDTO.toDomain(): TVShowDetail {
    return TVShowDetail(
        backdrop_path = backdrop_path ?: "",
        episode_run_time = episode_run_time ?: emptyList(),
        homepage = homepage ?: "",
        id = id ?: 0,
        in_production = in_production ?: false,
        languages = languages ?: emptyList(),
        name = name ?: "",
        number_of_episodes = number_of_episodes ?: 0,
        number_of_seasons = number_of_seasons ?: 0,
        original_name = original_name ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        status = status ?: "",
        tagline = tagline ?: "",
        type = type ?: "",
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0
    )
}