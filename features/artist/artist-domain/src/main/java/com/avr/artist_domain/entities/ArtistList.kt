package com.avr.artist_domain.entities

import com.avr.artist_domain.entities.Artist

data class ArtistList(
    val page: Int,
    val results: List<Artist>,
    val total_pages: Int,
    val total_results: Int
)