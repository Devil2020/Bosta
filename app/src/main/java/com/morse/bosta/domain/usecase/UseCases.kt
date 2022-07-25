package com.morse.bosta.domain.usecase

import com.morse.bosta.cache.AlbumsCaching
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.data.UserResponseItem
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.domain.repository.IUserRepository
import com.morse.bosta.utils.Response
import kotlinx.coroutines.flow.*


fun executeGetUserUseCase(repository: IUserRepository): Flow<Response> {
    return repository
        .loadUsers()
        .combine(repository.loadImages()) { users, images ->
            users.mapIndexed { index, userResponseItem -> userResponseItem.copy(image = images[index]) }
        }
        .map { Response.Success<UserResponseItem>(it.random()) as Response }
        .onStart {
            emit(Response.Loading)
        }
        .catch { emit(Response.Error(it.localizedMessage ?: it.toString())) }
}

fun executeGetUserAlbumsUseCase(repository: IAlbumsRepository, userId: Int): Flow<Response> {
    return repository.loadUserAlbums(userId)
        .map { Response.Success(it) as Response }
        .onStart { emit(Response.Loading) }
        .catch { emit(Response.Error(it.localizedMessage ?: it.toString())) }
}

fun executeGetAlbumPhotosUseCase(repository: IAlbumsRepository, albumId: Int): Flow<Response> {
    return repository.loadAlbumPhotos(albumId)
        .map {
            executeSaveAlbumPhotosUseCase(albumId, it)
            Response.Success(it) as Response
        }
        .onStart { emit(Response.Loading) }
        .catch { emit(Response.Error(it.localizedMessage ?: it.toString())) }
}

fun executeSearchPhotosUseCase(
    repository: IAlbumsRepository,
    albumId: Int,
    search: String
): Flow<Response> {
    return repository.loadAlbumPhotos(albumId)
        .map { photoItems ->
            Response.Success(photoItems.filter { photoItem ->
                photoItem.title.contains(search)
            }) as Response
        }
        .onStart { emit(Response.Loading) }
        .catch { emit(Response.Error(it.localizedMessage ?: it.toString())) }
}


private fun executeSaveAlbumPhotosUseCase(albumId: Int, photos: List<PhotosResponseItem>) =
    AlbumsCaching.saveAlbumPhotos(albumId, photos)