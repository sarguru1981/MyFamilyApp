package com.avr.moviemodule

import com.avr.core.BaseFeatureApi

interface MovieFeatureApi : BaseFeatureApi {

    fun movieRoute(): String
}