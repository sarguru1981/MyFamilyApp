package com.avr.dependency_provider

import com.avr.feature_home_api.HomeFeatureApi

object DependencyProvider {

    /* Don't use lateinit in real project :) */
    private lateinit var homeFeatureApi: HomeFeatureApi
  //  private lateinit var movieFeatureApi: MovieFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi,
      //  movieFeatureApi: MovieFeatureApi
    ) {
        DependencyProvider.homeFeatureApi = homeFeatureApi
      //  DependencyProvider.movieFeatureApi = movieFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi

   // fun movieFeature(): MovieFeatureApi = movieFeatureApi
}