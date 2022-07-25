package com.morse.bosta.app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.data.UserResponseItem
import com.morse.bosta.ui.albums.AlbumDetailsActivity
import com.morse.bosta.ui.profile.ProfileActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface Direction {
    abstract val lifeCycleScope: LifecycleCoroutineScope
    fun add()
}

interface Coordinator {
    fun navigate(direction: Direction)
    fun navigateAfter(time: Long = 1000L, direction: Direction)
    fun back(activity: AppCompatActivity)
}

class ProfileDirection(private val current: AppCompatActivity , private val user : UserResponseItem) : Direction {
    override val lifeCycleScope: LifecycleCoroutineScope
        get() = current.lifecycleScope

    override fun add() {
        current.finish()
        current.startActivity(Intent(current, ProfileActivity::class.java).apply {
            putExtra(ProfileActivity.userKey , user)
        })
    }
}

class AlbumDetailsDirection(private val current: AppCompatActivity , private val album : AlbumsResponseItem) : Direction {
    override val lifeCycleScope: LifecycleCoroutineScope
        get() = current.lifecycleScope

    override fun add() {
        current.startActivity(Intent(current, AlbumDetailsActivity::class.java).apply {
            putExtra(AlbumDetailsActivity.albumKey , album)
        })
    }

}

object BostaCoordinator : Coordinator {
    override fun navigate(direction: Direction) = direction.add()
    override fun navigateAfter(time: Long, direction: Direction) {
        direction.lifeCycleScope.launch {
            delay(time)
            navigate(direction)
        }
    }

    override fun back( activity: AppCompatActivity ) = activity.finish()
}