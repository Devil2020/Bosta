package com.morse.bosta.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morse.bosta.data.UserResponseItem
import com.morse.bosta.domain.repository.IAlbumsRepository
import com.morse.bosta.domain.usecase.executeGetUserAlbumsUseCase
import com.morse.bosta.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: IAlbumsRepository
) : ViewModel() {

    val profile: UserResponseItem by lazy {
        savedStateHandle[ProfileActivity.userKey] ?: UserResponseItem.fakeOne()
    }

    private val _albums = MutableSharedFlow<Response>()
    val albums: Flow<Response> get() = _albums

    init {
        loadAlbums()
    }

    private fun loadAlbums() {
        executeGetUserAlbumsUseCase(userId = profile.id, repository = repository)
            .onEach {
                _albums.emit(it)
            }
            .launchIn(viewModelScope)
    }


}