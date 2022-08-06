package com.avr.feature_home_api

import com.avr.core.BaseFeatureApi


interface HomeFeatureApi : BaseFeatureApi {

    fun homeRoute(): String
}