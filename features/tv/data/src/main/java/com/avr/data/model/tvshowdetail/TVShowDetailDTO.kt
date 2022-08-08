package com.avr.data.model.tvshowdetail

data class TVShowDetailDTO(
    val backdrop_path: String?,
    val episode_run_time: List<Int>?,
    val homepage: String?,
    val id: Int?,
    val in_production: Boolean?,
    val languages: List<String>?,
    val name: String?,
    val number_of_episodes: Int?,
    val number_of_seasons: Int?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val status: String?,
    val tagline: String?,
    val type: String?,
    val vote_average: Double?,
    val vote_count: Int?
)