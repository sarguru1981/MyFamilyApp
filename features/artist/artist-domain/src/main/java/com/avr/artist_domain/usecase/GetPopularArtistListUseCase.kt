package com.avr.artist_domain.usecase

import com.avr.artist_domain.entities.Artist
import com.avr.artist_domain.repository.ArtistListRepository
import com.avr.artist_domain.usecase.base.SingleUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPopularArtistListUseCase @Inject constructor(private val artistListRepository: ArtistListRepository) :
    SingleUseCase<List<Artist>>() {

    override fun buildUseCaseSingle(): Single<List<Artist>> {
        return artistListRepository.getPopularArtist()
    }
}