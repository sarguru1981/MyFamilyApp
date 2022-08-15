package com.avr.feature_artist_api

import com.avr.core.BaseFeatureApi

interface ArtistFeatureApi: BaseFeatureApi {

    fun artistRoute(): String
}