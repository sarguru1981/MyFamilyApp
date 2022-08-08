package com.avr.feature_tv_impl.popular.tvdetail

import com.avr.domain.entities.tvshowdetail.TVShowDetail

sealed class TVShowDetailState {
    object StartState : TVShowDetailState()
    object LoadingState : TVShowDetailState()
    data class Success(val tvShowDetail: TVShowDetail?) : TVShowDetailState()
    data class Error(val message: String) : TVShowDetailState()
}