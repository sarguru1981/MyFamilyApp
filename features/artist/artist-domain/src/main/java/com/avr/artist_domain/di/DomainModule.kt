package com.avr.artist_domain.di

import com.avr.artist_domain.repository.ArtistRepository
import com.avr.artist_domain.usecases.GetArtistListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideArtistListUseCase(
        artistRepository: ArtistRepository
    ): GetArtistListUseCase {
        return GetArtistListUseCase(artistRepository)
    }
}