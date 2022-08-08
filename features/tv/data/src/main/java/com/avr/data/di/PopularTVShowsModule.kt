package com.avr.data.di

import com.avr.data.repository.TVApiService
import com.avr.data.repository.TVShowDetailRepositoryImpl
import com.avr.data.repository.TVShowListRepositoryImpl
import com.avr.data.repository.datasource.TVShowDetailRemoteDataSource
import com.avr.data.repository.datasource.TVShowListRemoteDataSource
import com.avr.data.repository.datasourceimpl.TVShowDetailRemoteDataSourceImpl
import com.avr.data.repository.datasourceimpl.TVShowListRemoteDataSourceImpl
import com.avr.domain.repository.TVShowDetailRepository
import com.avr.domain.repository.TVShowListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class PopularTVShowsModule {

    /*TV Show List */
    @Provides
    fun provideGetPopularTVShowsRemoteDataSource(
        apiService: TVApiService,
        retrofit: Retrofit
    ): TVShowListRemoteDataSource {
        return TVShowListRemoteDataSourceImpl(apiService, retrofit)
    }

    @Provides
    fun provideGetPopularTVShowsDataSource(
        tvShowListRemoteDataSource: TVShowListRemoteDataSource
    ): TVShowListRepository {
        return TVShowListRepositoryImpl(
            tvShowListRemoteDataSource
        )
    }

    /*TV Show Detail */
    @Provides
    fun provideGetPopularTVShowDetailRemoteDataSource(
        apiService: TVApiService,
        retrofit: Retrofit
    ): TVShowDetailRemoteDataSource {
        return TVShowDetailRemoteDataSourceImpl(apiService, retrofit)
    }

    @Provides
    fun provideGetPopularTVShowDetailDataSource(
        tvShowDetailRemoteDataSource: TVShowDetailRemoteDataSource
    ): TVShowDetailRepository {
        return TVShowDetailRepositoryImpl(
            tvShowDetailRemoteDataSource
        )
    }
}