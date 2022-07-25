package com.morse.bosta.domain.repository

import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import kotlinx.coroutines.flow.Flow

interface IAlbumsRepository {
    fun loadUserAlbums(userId: Int): Flow<List<AlbumsResponseItem>>
    fun loadAlbumPhotos(albumId: Int): Flow<List<PhotosResponseItem>>
}