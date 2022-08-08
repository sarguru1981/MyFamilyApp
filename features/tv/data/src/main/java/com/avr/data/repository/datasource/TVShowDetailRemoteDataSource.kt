package com.avr.data.repository.datasource

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail

interface TVShowDetailRemoteDataSource {

    suspend fun getPopularTVShowDetailFromRemote(id: String): Output<TVShowDetail>
}