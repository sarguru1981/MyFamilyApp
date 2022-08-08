package com.avr.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.avr.domain.entities.tvshowlist.TVShowItem


@Database(
    entities = [TVShowItem::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListOfStringToStringTypeConvertor::class, ListOfIntToIntTypeConvertor::class)
abstract class TVShowDatabase : RoomDatabase() {
    companion object {
        fun getInstance(context: Context): TVShowDatabase {
            return Room.databaseBuilder(context, TVShowDatabase::class.java, "tv-shows").build()
        }
    }

    abstract fun getTVShowDAO(): TVShowDAO
}