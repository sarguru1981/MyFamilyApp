package com.avr.domain.usecases

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowlist.TVShowItem
import com.avr.domain.repository.TVShowListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularTVShowsUseCase @Inject constructor(private val tvShowListRepository: TVShowListRepository) {

    suspend operator fun invoke(): Flow<Output<List<TVShowItem>>>{
        return tvShowListRepository.getPopularTVList()
    }
}