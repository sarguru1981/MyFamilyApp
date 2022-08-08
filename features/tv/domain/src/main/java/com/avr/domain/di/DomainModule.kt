package com.avr.domain.di

import com.avr.domain.repository.TVShowDetailRepository
import com.avr.domain.repository.TVShowListRepository
import com.avr.domain.usecases.GetPopularTVShowDetailUseCase
import com.avr.domain.usecases.GetPopularTVShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideGetPopularTVShowsUseCase(tvShowListRepository: TVShowListRepository): GetPopularTVShowsUseCase {
        return GetPopularTVShowsUseCase(tvShowListRepository)
    }

    @Provides
    fun provideGetPopularTVShowDetailUseCase(tvShowDetailRepository: TVShowDetailRepository): GetPopularTVShowDetailUseCase {
        return GetPopularTVShowDetailUseCase(tvShowDetailRepository)
    }
}