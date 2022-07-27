package com.morse.bosta.cache

import com.morse.bosta.data.PhotosResponseItem

interface Cache {

    fun isAlbumExist(albumId: Int)  :Boolean

    fun saveAlbumPhotos(albumId: Int, incomingPhotos: List<PhotosResponseItem>)

    suspend fun loadAlbumPhotos(albumId: Int): List<PhotosResponseItem>

}