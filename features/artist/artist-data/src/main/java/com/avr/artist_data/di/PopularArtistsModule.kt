package com.avr.artist_data.di

import com.avr.artist_data.repository.ArtistApiService
import com.avr.artist_data.repository.ArtistListRepositoryImpl
import com.avr.artist_data.repository.datasource.ArtistListRemoteDataSource
import com.avr.artist_data.repository.datasourceimpl.ArtistListRemoteDataSourceImpl
import com.avr.artist_domain.repository.ArtistListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class PopularArtistsModule {

    /*Artist List */
    @Provides
    fun provideGetPopularArtistListRemoteDataSource(
        apiService: ArtistApiService,
        retrofit: Retrofit
    ): ArtistListRemoteDataSource {
        return ArtistListRemoteDataSourceImpl(apiService, retrofit)
    }

    @Provides
    fun provideGetPopularArtistListDataSource(
        artistListRemoteDataSource: ArtistListRemoteDataSource
    ): ArtistListRepository {
        return ArtistListRepositoryImpl(
            artistListRemoteDataSource
        )
    }
}