package com.avr.domain.entities.tvshowlist

data class TVShows(
    val page: Int,
    val TVShowItemDTOS: List<TVShowItem>,
    val total_pages: Int,
    val total_results: Int
)