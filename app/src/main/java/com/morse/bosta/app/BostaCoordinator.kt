package com.morse.bosta.app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.morse.bosta.ui.albums.AlbumDetailsActivity
import com.morse.bosta.ui.profile.ProfileActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface Direction {
    abstract val lifeCycleScope: LifecycleCoroutineScope
    fun add()
    fun delete()
}

interface Coordinator {
    fun navigate(direction: Direction)
    fun navigateAfter(time: Long = 1000L, direction: Direction)
    fun back()
}

class ProfileDirection(private val current: AppCompatActivity) : Direction {
    override val lifeCycleScope: LifecycleCoroutineScope
        get() = current.lifecycleScope

    override fun add() {
        current.finish()
        current.startActivity(Intent(current, ProfileActivity::class.java))
    }

    override fun delete() {
        current.finish()
    }
}

class AlbumDetailsDirection(private val current: AppCompatActivity) : Direction {
    override val lifeCycleScope: LifecycleCoroutineScope
        get() = current.lifecycleScope

    override fun add() {
        current.finish()
        current.startActivity(Intent(current, AlbumDetailsActivity::class.java))
    }

    override fun delete() {
        current.finish()
    }
}

object BostaCoordinator : Coordinator {
    private lateinit var lastDirection: Direction
    override fun navigate(direction: Direction) = direction.add().also { lastDirection = direction }
    override fun navigateAfter(time: Long, direction: Direction) {
        direction.lifeCycleScope.launch {
            delay(time)
            navigate(direction)
        }
    }

    override fun back() = lastDirection.delete()
}