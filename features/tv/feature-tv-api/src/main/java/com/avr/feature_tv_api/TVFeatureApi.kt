package com.avr.feature_tv_api

import com.avr.core.BaseFeatureApi

interface TVFeatureApi: BaseFeatureApi {

    fun tvRoute(): String
}