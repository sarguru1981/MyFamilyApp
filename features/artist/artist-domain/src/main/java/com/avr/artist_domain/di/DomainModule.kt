package com.avr.artist_domain.di

import com.avr.artist_domain.repository.ArtistListRepository
import com.avr.artist_domain.usecase.GetPopularArtistListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideGetPopularArtistListUseCase(artistListRepository: ArtistListRepository): GetPopularArtistListUseCase {
        return GetPopularArtistListUseCase(artistListRepository)
    }
}