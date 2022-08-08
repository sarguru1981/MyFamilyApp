package com.avr.feature_tv_impl.popular.tvdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avr.domain.base.Output
import com.avr.domain.usecases.GetPopularTVShowDetailUseCase
import com.avr.feature_tv_impl.popular.tvlist.TVShowListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularTVShowDetailViewModel @Inject constructor(
    private val getPopularTVShowDetailUseCase: GetPopularTVShowDetailUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _tvShowState = MutableStateFlow<TVShowDetailState>(TVShowDetailState.StartState)

    // The UI collects from this StateFlow to get its state updates
    val tvShowState: StateFlow<TVShowDetailState> = _tvShowState

    init {
        savedStateHandle.getLiveData<String>("tv_id").value?.let {
            getPopularTVShowDetail(it)
        }
    }

    fun getPopularTVShowDetail(id: String) {
        viewModelScope.launch {
            getPopularTVShowDetailUseCase.invoke(id).collect {
                when (it.status) {
                    Output.Status.SUCCESS -> _tvShowState.value =
                        TVShowDetailState.Success(it.data)
                    Output.Status.ERROR -> _tvShowState.value =
                        TVShowDetailState.Error(it.message.toString())
                    Output.Status.LOADING -> _tvShowState.value = TVShowDetailState.LoadingState
                }
            }
        }
    }
}