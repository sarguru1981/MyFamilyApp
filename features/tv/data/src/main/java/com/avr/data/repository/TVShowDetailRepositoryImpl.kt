package com.avr.data.repository

import com.avr.data.repository.datasource.TVShowDetailRemoteDataSource
import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import com.avr.domain.repository.TVShowDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TVShowDetailRepositoryImpl @Inject constructor(
    private val tvShowDetailRemoteDataSource: TVShowDetailRemoteDataSource
) : TVShowDetailRepository {

    override suspend fun getPopularTVShowDetail(id: String): Flow<Output<TVShowDetail>> {
        return flow {
            emit(Output.loading())
            val result = tvShowDetailRemoteDataSource.getPopularTVShowDetailFromRemote(id)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}