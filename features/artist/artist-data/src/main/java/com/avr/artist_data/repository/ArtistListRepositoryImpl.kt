package com.avr.artist_data.repository


import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_domain.entities.Artist
import com.avr.artist_domain.repository.ArtistListRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ArtistListRepositoryImpl @Inject constructor(
    private val artistListRemoteDataSource: ArtistListRemoteDataSource
): ArtistListRepository {

    override fun getPopularArtist(): Single<List<Artist>> {
        return artistListRemoteDataSource.getPopularArtistsFromRemote()
    }
}