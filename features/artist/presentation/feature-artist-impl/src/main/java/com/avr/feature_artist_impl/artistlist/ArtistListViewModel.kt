package com.avr.feature_artist_impl.artistlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avr.artist_domain.entities.Artist
import com.avr.artist_domain.usecase.GetPopularArtistListUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArtistListViewModel @Inject constructor(private val getPopularArtistListUseCase: GetPopularArtistListUseCase) :
    ViewModel() {

    private val _artist = MutableLiveData<List<Artist>>()
    val artist: LiveData<List<Artist>> = _artist

    fun loadArtist() {
        getPopularArtistListUseCase.execute(
            onSuccess = {
                _artist.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }


}