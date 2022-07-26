package com.morse.bosta.ui.zoom

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.morse.bosta.data.PhotosResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ZoomViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {

    val photo: PhotosResponseItem by lazy {
        savedStateHandle[ZoomOutAndInActivity.photoKey] ?: PhotosResponseItem.createFakeOne()
    }

}