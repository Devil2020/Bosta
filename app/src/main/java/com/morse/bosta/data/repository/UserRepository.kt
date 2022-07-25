package com.morse.bosta.data.repository

import com.morse.bosta.data.UserResponseItem
import com.morse.bosta.domain.repository.IUserRepository
import com.morse.bosta.remote.Api
import com.morse.bosta.utils.execute
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

class UserRepository @Inject constructor (private val api: Api) : IUserRepository {

    private val imagesCount = 50

    override fun loadUsers(): Flow<List<UserResponseItem>> {
        return execute {
            api.getUsers()
        }
    }

    override fun loadImages(): Flow<List<String>> {
        return execute {
            loadRandomImages(imagesCount)
        }
    }

    private suspend fun loadRandomImages(size: Int): List<String> {
        val randomNumber = Random(size)
        val images = ArrayList<String>()
        for (index in 0..size) {
            images.add("https://randomuser.me/api/portraits/men/${(1..100).random()}.jpg")
        }
        return images
    }
}