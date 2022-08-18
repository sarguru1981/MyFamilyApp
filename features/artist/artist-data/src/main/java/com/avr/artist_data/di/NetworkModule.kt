package com.avr.artist_data.di

import com.avr.artist_data.repository.ArtistApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): ArtistApiService {
        return retrofit.create(ArtistApiService::class.java)
    }
}
