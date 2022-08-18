package com.avr.feature_artist_impl.artistlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.avr.artist_domain.entities.Artist
import com.avr.feature_artist_impl.R
import com.avr.feature_artist_impl.databinding.HolderArtistBinding
import com.bumptech.glide.Glide

internal class ArtistAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val artistList: MutableList<Artist> = ArrayList()

    /*
     * This method is called right when adapter is created &
     * is used to initialize ViewHolders
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderArtistBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.holder_artist, parent, false
        )
        return ArtistViewHolder(holderArtistBinding)
    }

    /* It is called for each ViewHolder to bind it to the adapter &
     * This is where we pass data to ViewHolder
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArtistViewHolder).onBind(getItem(position))
    }

    private fun getItem(position: Int): Artist {
        return artistList[position]
    }

    /*
     * This method returns the size of collection that contains the items we want to display
     * */
    override fun getItemCount(): Int {
        return artistList.size
    }

    fun addData(list: List<Artist>) {
        this.artistList.clear()
        this.artistList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ArtistViewHolder(
        private val dataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(dataBinding.root) {

        fun onBind(artist: Artist) {
            val holderArtistBinding = dataBinding as HolderArtistBinding
            val artistViewModel = ArtistViewModel(artist)
            holderArtistBinding.artistViewModel = artistViewModel

            val posterURL = "https://image.tmdb.org/t/p/w500"+artist.profile_path
            Glide.with(holderArtistBinding.imageView.context)
                .load(posterURL)
                .into(holderArtistBinding.imageView)
        }
    }
}
