package com.avr.feature_tv_impl.popular.tvlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avr.domain.base.Output
import com.avr.domain.usecases.GetPopularTVShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularTVShowListViewModel @Inject constructor(private val getPopularTVShowsUseCase: GetPopularTVShowsUseCase) :
    ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _tvShowListState = MutableStateFlow<TVShowListState>(TVShowListState.StartState)

    // The UI collects from this StateFlow to get its state updates
    val tvShowListState: StateFlow<TVShowListState> = _tvShowListState

    init {
        getPopularTVShowList()
    }

    fun getPopularTVShowList() {
        viewModelScope.launch {
            getPopularTVShowsUseCase.invoke().collect {
                when (it.status) {
                    Output.Status.SUCCESS -> _tvShowListState.value =
                        TVShowListState.Success(it.data)
                    Output.Status.ERROR -> _tvShowListState.value =
                        TVShowListState.Error(it.message.toString())
                    Output.Status.LOADING -> _tvShowListState.value = TVShowListState.LoadingState
                }
            }
        }
    }
}