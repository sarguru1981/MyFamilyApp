package com.avr.data.repository.datasourceimpl

import com.avr.data.mappers.toDomain
import com.avr.data.repository.BaseRemoteDataSource
import com.avr.data.repository.TVApiService
import com.avr.data.repository.datasource.TVShowListRemoteDataSource
import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowlist.TVShowItem
import retrofit2.Retrofit
import javax.inject.Inject

class TVShowListRemoteDataSourceImpl @Inject constructor(
    private val apiService: TVApiService,
    retrofit: Retrofit
) : TVShowListRemoteDataSource, BaseRemoteDataSource(retrofit) {

    override suspend fun getPopularTVShowsFromRemote(): Output<List<TVShowItem>> {
        return getListResponse(
            request = { apiService.getPopularTVShowList().body()?.results!!.toDomain() }
        )
    }
}