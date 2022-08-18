package com.avr.feature_artist_impl.artistlist

import androidx.lifecycle.MutableLiveData
import com.avr.artist_domain.entities.Artist

/**A helper class for the UI controller that is responsible for
 * preparing data for [ArtistViewModel] as the UI
 *
 * @CREATOR ZARA
 * */
class ArtistViewModel(val artist: Artist) {

    private val TAG = ArtistViewModel::class.java.simpleName
    val artistData = MutableLiveData<Artist>()

    init {
        artistData.value = artist
    }
}
