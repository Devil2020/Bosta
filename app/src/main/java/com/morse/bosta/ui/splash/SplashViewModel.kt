package com.morse.bosta.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.morse.bosta.domain.repository.IUserRepository
import com.morse.bosta.domain.usecase.executeGetUserUseCase
import com.morse.bosta.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor (private val repository: IUserRepository) : ViewModel() {

    val user = executeGetUserUseCase(repository)
        .stateIn(viewModelScope, SharingStarted.Lazily, Response.Idle)

}