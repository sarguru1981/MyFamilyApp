package com.avr.feature_artist_impl.artistlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.avr.artist_domain.entities.Artist
import com.avr.feature_artist_impl.R
import com.avr.feature_artist_impl.databinding.FragmentArtistsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private lateinit var fragmentArtistsBinding: FragmentArtistsBinding
    private var adapter: ArtistAdapter? = null

    private val viewModel: ArtistsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArtistAdapter()
        viewModel.loadArtists()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentArtistsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_artists, container, false)
        fragmentArtistsBinding.artistsViewModel = viewModel
        fragmentArtistsBinding.artistsRecyclerView.adapter = adapter

        viewModel.isLoad.observe(
            viewLifecycleOwner,
            Observer {
                it?.let { visibility ->
                    fragmentArtistsBinding.artistsProgressBar.visibility = if (visibility) View.GONE else View.VISIBLE
                }
            }
        )

        viewModel.artistList.observe(
            viewLifecycleOwner,
            Observer {
                it?.let {
                    initRecyclerView(it)
                }
            }
        )

        return fragmentArtistsBinding.root
    }

    private fun initRecyclerView(artists: List<Artist>) {
        adapter?.addData(artists)
    }

    override fun onDetach() {
        super.onDetach()
        adapter = null
    }

    companion object {

        val FRAGMENT_NAME = ArtistFragment::class.java.name

        @JvmStatic
        fun newInstance() =
            ArtistFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
