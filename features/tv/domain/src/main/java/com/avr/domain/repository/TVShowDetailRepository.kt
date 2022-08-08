package com.avr.domain.repository

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import kotlinx.coroutines.flow.Flow

interface TVShowDetailRepository {

    suspend fun getPopularTVShowDetail(id: String): Flow<Output<TVShowDetail>>
}