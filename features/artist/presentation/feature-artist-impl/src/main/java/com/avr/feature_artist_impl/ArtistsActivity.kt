package com.avr.feature_artist_impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avr.feature_artist_impl.artistlist.ArtistFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        if (savedInstanceState == null) {
            navigateToGalleryPage()
        }
    }

    private fun navigateToGalleryPage() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.artist_container,
                ArtistFragment.newInstance(),
                ArtistFragment.FRAGMENT_NAME
            ).commitAllowingStateLoss()
    }
}
