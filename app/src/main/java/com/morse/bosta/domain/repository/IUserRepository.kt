package com.morse.bosta.domain.repository

import com.morse.bosta.data.UserResponseItem
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun loadUsers(): Flow<List<UserResponseItem>>
    fun loadImages(): Flow<List<String>>
}