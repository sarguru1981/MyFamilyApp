package com.avr.feature_artist_impl.artistlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avr.artist_domain.entities.Artist
import com.avr.artist_domain.usecases.GetArtistListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArtistsViewModel @Inject constructor(private val getArtistListUseCase: GetArtistListUseCase) :
    ViewModel() {

    val artistList = MutableLiveData<List<Artist>>()
    val isLoad = MutableLiveData<Boolean>()
    val artistListData = MutableLiveData<Artist>()

    init {
        isLoad.value = false
    }

    val artist: Artist? get() = artistListData.value

    fun set(artist: Artist) = run { artistListData.value = artist }

    fun loadArtists() {
        getArtistListUseCase.execute(
            onSuccess = {
                isLoad.value = true
                artistList.value = it.results
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}
