package com.morse.bosta.ui.albums

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.domain.usecase.executeGetAlbumPhotosUseCase
import com.morse.bosta.domain.usecase.executeGetUserAlbumsUseCase
import com.morse.bosta.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: IAlbumsRepository
) : ViewModel() {

    val album: AlbumsResponseItem by lazy {
        savedStateHandle[AlbumDetailsActivity.albumKey] ?: AlbumsResponseItem.createFakeOne()
    }

    private val _albumPhotos = MutableSharedFlow<Response>()
    val albumPhotos: Flow<Response> get() = _albumPhotos

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        executeGetAlbumPhotosUseCase(
            repository, album.id
        ).onEach { _albumPhotos.emit(it) }
            .launchIn(viewModelScope)
    }

    fun search(name: String) {

    }

}