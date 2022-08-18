package com.avr.artist_data.di

import com.avr.artist_data.repository.ArtistApiService
import com.avr.artist_data.repository.ArtistRepositoryImpl
import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_data.repository.datasourceimpl.ArtistListRemoteDataSourceImpl
import com.avr.artist_domain.repository.ArtistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ArtistListModule {

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(
        artistApiService: ArtistApiService
    ): ArtistListRemoteDataSource {
        return ArtistListRemoteDataSourceImpl(artistApiService)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistListRemoteDataSource: ArtistListRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistListRemoteDataSource)
    }
}