package com.avr.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avr.domain.entities.tvshowlist.TVShowItem

@Dao
interface TVShowDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularTVShows(tvShows : List<TVShowItem>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllPopularTVShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getPopularTVShows():List<TVShowItem>
}