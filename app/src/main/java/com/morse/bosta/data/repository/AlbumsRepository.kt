package com.morse.bosta.data.repository

import com.morse.bosta.cache.AlbumsCaching
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.remote.Api
import com.morse.bosta.utils.execute
import com.morse.bosta.utils.run
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val api: Api) : IAlbumsRepository {

    override fun loadUserAlbums(userId: Int): Flow<List<AlbumsResponseItem>> {
        return execute {
            api.getUserAlbums(userId)
        }
    }
    /* Here i make a Single Source Of Truth Because The Search is an Expensive Operation */
    override fun loadAlbumPhotos(albumId: Int): Flow<List<PhotosResponseItem>> {
        return execute(!AlbumsCaching.isAlbumExist(albumId), {
            val networkResponse = api.getAlbumPhotos(albumId)
            AlbumsCaching.saveAlbumPhotos(albumId, networkResponse)
        }, {
            AlbumsCaching.loadAlbumPhotos(albumId)
        })
    }
}