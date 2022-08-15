package com.avr.artist_data.model

data class ArtistListDTO(
    val page: Int?,
    val results: List<ArtistDTO>?,
    val total_pages: Int?,
    val total_results: Int?
)