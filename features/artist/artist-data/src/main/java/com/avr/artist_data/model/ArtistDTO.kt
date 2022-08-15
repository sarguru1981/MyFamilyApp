package com.avr.artist_data.model

data class ArtistDTO(
    val adult: Boolean?,
    val gender: Int?,
    val id: Int?,
    val known_for_department: String?,
    val name: String?,
    val popularity: Double?,
    val profile_path: String?
)