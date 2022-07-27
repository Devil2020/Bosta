package com.morse.bosta.cache

import com.morse.bosta.data.PhotosResponseItem

object AlbumsCaching  : Cache {

    private val photos = HashMap<Int, List<PhotosResponseItem>>()

    override fun isAlbumExist(albumId: Int) = photos.containsKey(albumId)

    override fun saveAlbumPhotos(albumId: Int, incomingPhotos: List<PhotosResponseItem>) {
        if (photos.containsKey(albumId)) {
            return
        }
        photos[albumId] = incomingPhotos
    }

    override suspend fun loadAlbumPhotos (albumId: Int) : List<PhotosResponseItem>{
        return  photos[albumId] ?: emptyList()
    }

}