package com.avr.data.repository

import com.avr.data.repository.datasource.TVShowListRemoteDataSource
import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowlist.TVShowItem
import com.avr.domain.repository.TVShowListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TVShowListRepositoryImpl @Inject constructor(
    private val tvShowListRemoteDataSource: TVShowListRemoteDataSource
): TVShowListRepository {

    override suspend fun getPopularTVList(): Flow<Output<List<TVShowItem>>> {
        return flow {
            emit(Output.loading())
            val result = tvShowListRemoteDataSource.getPopularTVShowsFromRemote()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}