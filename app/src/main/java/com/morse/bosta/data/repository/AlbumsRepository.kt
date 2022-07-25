package com.morse.bosta.data.repository

import com.morse.bosta.cache.AlbumsCaching
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.remote.Api
import com.morse.bosta.utils.execute
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val api: Api) : IAlbumsRepository {

    override fun loadUserAlbums(userId: Int): Flow<List<AlbumsResponseItem>> {
        return execute {
            api.getUserAlbums(userId)
        }
    }

    override fun loadAlbumPhotos(albumId: Int): Flow<List<PhotosResponseItem>> {
        return execute {
            if (AlbumsCaching.isAlbumExist(albumId)) {
                AlbumsCaching.loadAlbumPhotos(albumId)
            } else {
                api.getAlbumPhotos(
                    albumId
                )
            }
        }
    }
}