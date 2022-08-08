package com.avr.data.repository.datasource

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowlist.TVShowItem

interface TVShowListRemoteDataSource {

    suspend fun getPopularTVShowsFromRemote(): Output<List<TVShowItem>>
}