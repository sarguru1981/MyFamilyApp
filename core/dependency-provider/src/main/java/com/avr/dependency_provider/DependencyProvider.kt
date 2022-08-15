package com.avr.dependency_provider

import com.avr.feature_artist_api.ArtistFeatureApi
import com.avr.feature_home_api.HomeFeatureApi
import com.avr.feature_tv_api.TVFeatureApi

object DependencyProvider {

    /* Don't use lateinit in real project :) */
    private lateinit var homeFeatureApi: HomeFeatureApi
  //  private lateinit var movieFeatureApi: MovieFeatureApi
    private lateinit var tvFeatureApi: TVFeatureApi
    private lateinit var artistFeatureApi: ArtistFeatureApi

    fun provideImpl(
        homeFeatureApi: HomeFeatureApi,
      //  movieFeatureApi: MovieFeatureApi
        tvFeatureApi: TVFeatureApi,
        artistFeatureApi: ArtistFeatureApi
    ) {
        DependencyProvider.homeFeatureApi = homeFeatureApi
      //  DependencyProvider.movieFeatureApi = movieFeatureApi
        DependencyProvider.tvFeatureApi = tvFeatureApi
        DependencyProvider.artistFeatureApi = artistFeatureApi
    }

    fun homeFeature(): HomeFeatureApi = homeFeatureApi

   // fun movieFeature(): MovieFeatureApi = movieFeatureApi

    fun tvFeature(): TVFeatureApi = tvFeatureApi

    fun artistFeature(): ArtistFeatureApi = artistFeatureApi
}