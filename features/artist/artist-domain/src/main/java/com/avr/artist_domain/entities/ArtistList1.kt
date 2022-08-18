package com.avr.artist_domain.entities

data class ArtistList1(
    val `data`: List<Artist1>,
    val limit: Int,
    val page: Int,
    val total: Int
)