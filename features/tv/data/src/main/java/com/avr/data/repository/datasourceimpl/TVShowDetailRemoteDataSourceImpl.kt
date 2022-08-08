package com.avr.data.repository.datasourceimpl

import com.avr.data.mappers.toDomain
import com.avr.data.repository.BaseRemoteDataSource
import com.avr.data.repository.TVApiService
import com.avr.data.repository.datasource.TVShowDetailRemoteDataSource
import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import retrofit2.Retrofit
import javax.inject.Inject

class TVShowDetailRemoteDataSourceImpl @Inject constructor(
    private val apiService: TVApiService,
    retrofit: Retrofit
) : TVShowDetailRemoteDataSource, BaseRemoteDataSource(retrofit) {

    override suspend fun getPopularTVShowDetailFromRemote(id: String): Output<TVShowDetail> {
        return getObjectResponse(
            request = { apiService.getPopularTVShowDetail(id = id).body()?.toDomain()!! },
            defaultErrorMessage = "Error fetching TV Details"
        )
    }
}