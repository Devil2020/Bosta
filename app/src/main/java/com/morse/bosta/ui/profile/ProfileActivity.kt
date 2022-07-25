package com.morse.bosta.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.morse.bosta.R
import com.morse.bosta.app.AlbumDetailsDirection
import com.morse.bosta.app.BostaCoordinator
import com.morse.bosta.app.Direction
import com.morse.bosta.data.AlbumsResponseItem
import com.morse.bosta.databinding.ActivityProfileBinding
import com.morse.bosta.ui.splash.SplashViewModel
import com.morse.bosta.utils.BaseActivity
import com.morse.bosta.utils.Response
import com.morse.bosta.utils.Toaster
import com.morse.bosta.utils.collect
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    companion object {
        const val userKey = "UserProfile"
    }
    private val vm by viewModels<ProfileViewModel>()
    lateinit var adapter: AlbumsAdapter

    override fun onStart() {
        super.onStart()
        adapter = AlbumsAdapter {
            BostaCoordinator.navigate(AlbumDetailsDirection(this, it))
        }
        binding.apply {
            user = vm.profile
            albumsRecyclerView.adapter = adapter
        }
        observeOnViewModel()
    }

    private fun observeOnViewModel() {
        collect(vm.albums) {
            when (it) {
                is Response.Loading -> {
                    binding.albumsLoading.isLoading = true
                }
                is Response.Success<*> -> {
                    binding.albumsLoading.isLoading = false
                    adapter.submit(it.response as List<AlbumsResponseItem>)
                }
                is Response.Error -> {
                    binding.albumsLoading.isLoading = false
                    Toaster.showError(this, "Fail Get Albums Because ${it.reason}")
                }
                else -> {
                    binding.albumsLoading.isLoading = false
                }
            }
        }
    }

}