package com.avr.domain.repository

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowlist.TVShowItem
import kotlinx.coroutines.flow.Flow

interface TVShowListRepository {

    suspend fun getPopularTVList(): Flow<Output<List<TVShowItem>>>
}