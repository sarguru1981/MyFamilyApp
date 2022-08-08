package com.avr.data.di

import android.content.Context
import com.avr.data.database.TVShowDAO
import com.avr.data.database.TVShowDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TVShowDatabase {
        return TVShowDatabase.getInstance(context)
    }

    @Provides
    fun provideDAO(tvShowDatabase: TVShowDatabase): TVShowDAO {
        return tvShowDatabase.getTVShowDAO()
    }
}