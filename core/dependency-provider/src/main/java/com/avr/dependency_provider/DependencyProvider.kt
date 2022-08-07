package com.avr.dependency_provider

import com.avr.feature_home_api.HomeFeatureApi
import com.avr.feature_tv_api.TVFeatureApi

object DependencyProvider {

    /* Don't use lateinit in real project :) */
    private lateinit var homeFeatureApi: HomeFeatureApi
  //  private lateinit var movieFeatureApi: MovieFeatureApi
    private lateinit var tvFeatureApi: TVFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi,
      //  movieFeatureApi: MovieFeatureApi
        tvFeatureApi: TVFeatureApi
    ) {
        DependencyProvider.homeFeatureApi = homeFeatureApi
      //  DependencyProvider.movieFeatureApi = movieFeatureApi
        DependencyProvider.tvFeatureApi = tvFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi

   // fun movieFeature(): MovieFeatureApi = movieFeatureApi

    fun tvFeature(): TVFeatureApi = tvFeatureApi
}