package com.avr.data.di

import com.avr.data.repository.TVApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): TVApiService {
        return retrofit.create(TVApiService::class.java)
    }
}