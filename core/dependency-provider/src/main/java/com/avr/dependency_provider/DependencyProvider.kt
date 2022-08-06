package com.avr.dependency_provider

import com.avr.feature_home_api.HomeFeatureApi

object DependencyProvider {

    /* Don't use lateinit in real project :) */
    private lateinit var homeFeatureApi: HomeFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi
    ) {
        DependencyProvider.homeFeatureApi = homeFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi
}