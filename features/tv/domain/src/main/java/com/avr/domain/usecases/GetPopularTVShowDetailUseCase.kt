package com.avr.domain.usecases

import com.avr.domain.base.Output
import com.avr.domain.entities.tvshowdetail.TVShowDetail
import com.avr.domain.repository.TVShowDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularTVShowDetailUseCase @Inject constructor(private val tvShowDetailRepository: TVShowDetailRepository) {

    suspend operator fun invoke(id: String): Flow<Output<TVShowDetail>> {
        return tvShowDetailRepository.getPopularTVShowDetail(id)
    }
}