package com.morse.bosta.cache

import com.morse.bosta.data.PhotosResponseItem

object AlbumsCaching {

    private val photos = HashMap<Int, List<PhotosResponseItem>>()

    fun isAlbumExist(albumId: Int) = photos.containsKey(albumId)

    fun saveAlbumPhotos(albumId: Int, incomingPhotos: List<PhotosResponseItem>) {
        if (photos.containsKey(albumId)) {
            return
        }
        photos[albumId] = incomingPhotos
    }

    suspend fun loadAlbumPhotos (albumId: Int) : List<PhotosResponseItem>{
        return  photos[albumId] ?: emptyList()
    }

}