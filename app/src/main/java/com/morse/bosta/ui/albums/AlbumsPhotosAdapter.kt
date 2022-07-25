package com.morse.bosta.ui.albums

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.databinding.AlbumItemLayoutBinding
import com.morse.bosta.databinding.PhotoItemLayoutBinding
import com.morse.bosta.ui.profile.AlbumsAdapter

class AlbumsPhotosAdapter (private val listener: (PhotosResponseItem) -> Unit) :
    RecyclerView.Adapter<AlbumsPhotosAdapter.PhotoViewHolder>() {

    private val photos = ArrayList<PhotosResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submit(data: List<PhotosResponseItem>) {
        photos.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return AlbumsPhotosAdapter.PhotoViewHolder(
            PhotoItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.renderPhoto(listener, photo = photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

     class PhotoViewHolder(private val binding: PhotoItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun renderPhoto(listener: (PhotosResponseItem) -> Unit, photo: PhotosResponseItem) {
            binding.root.setOnClickListener { listener.invoke(photo) }
            binding.photoItem = photo
        }

    }

}