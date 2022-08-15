package com.avr.artist_domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artist_table")
data class Artist(
    val adult: Boolean,
    val gender: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val known_for_department: String,
    val name: String,
    val popularity: Double,
    val profile_path: String
)