package com.avr.artist_domain.usecases

import com.avr.artist_domain.entities.ArtistList
import com.avr.artist_domain.repository.ArtistRepository
import com.avr.artist_domain.usecases.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject


class GetArtistListUseCase @Inject constructor(
    private val repository: ArtistRepository
) : SingleUseCase<ArtistList>() {

    override fun buildUseCaseSingle(): Single<ArtistList> {
        return repository.getArtistList()
    }
}
