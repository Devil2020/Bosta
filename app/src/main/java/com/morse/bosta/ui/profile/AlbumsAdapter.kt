package com.morse.bosta.ui.profile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.databinding.AlbumItemLayoutBinding


class AlbumsAdapter(val listener: (AlbumsResponseItem) -> Unit) :
    RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    private val albums = ArrayList<AlbumsResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submit(data: List<AlbumsResponseItem>) {
        albums.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            AlbumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.renderAlbum(listener, position.inc(), album = albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    public class AlbumViewHolder(private val binding: AlbumItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun renderAlbum(
            listener: (AlbumsResponseItem) -> Unit,
            number: Int,
            album: AlbumsResponseItem
        ) {
            binding.albumCard.setOnClickListener { listener.invoke(album) }
            binding.albumName.text = album.title
            binding.albumNumber.text = number.toString()
        }

    }

}