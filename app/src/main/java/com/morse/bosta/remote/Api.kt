package com.morse.bosta.remote

import com.morse.bosta.BuildConfig
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.data.UserResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET(BuildConfig.USERS_URL)
    suspend fun getUsers(): List<UserResponseItem>

    @GET(BuildConfig.ALBUMS_URL)
    suspend fun getUserAlbums(@Query("userId") userId: Int): List<AlbumsResponseItem>

    @GET(BuildConfig.ALBUM_PHOTOS_URL)
    suspend fun getAlbumPhotos(@Query("albumId") albumId: Int): List<PhotosResponseItem>


}