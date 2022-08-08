package com.avr.feature_tv_impl.popular.tvlist

import com.avr.domain.entities.tvshowlist.TVShowItem

sealed class TVShowListState {
    object StartState : TVShowListState()
    object LoadingState : TVShowListState()
    data class Success(val tvShows: List<TVShowItem>?) : TVShowListState()
    data class Error(val message: String) : TVShowListState()
}
