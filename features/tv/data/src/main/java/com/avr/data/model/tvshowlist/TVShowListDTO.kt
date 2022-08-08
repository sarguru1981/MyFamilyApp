package com.avr.data.model.tvshowlist

data class TVShowListDTO(
    val page: Int,
    val results: List<TVShowItemDTO>,
    val total_pages: Int,
    val total_results: Int
)