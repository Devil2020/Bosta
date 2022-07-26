package com.morse.bosta.ui.albums

import android.os.Bundle
import android.view.Menu
import android.widget.Adapter
import android.widget.Toolbar
import androidx.activity.viewModels
import com.morse.bosta.R
import com.morse.bosta.app.BostaCoordinator
import com.morse.bosta.app.Coordinator
import com.morse.bosta.app.PhotoZoomInOutDirection
import com.morse.bosta.data.PhotosResponseItem
import com.morse.bosta.databinding.ActivityAlbumDetailsBinding
import com.morse.bosta.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailsActivity :
    BaseActivity<ActivityAlbumDetailsBinding>(R.layout.activity_album_details) {

    companion object {
        const val albumKey = "AlbumInformation"
    }

    private val vm by viewModels<AlbumsViewModel>()
    private lateinit var adapter: AlbumsPhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.photosAlbumsToolbar)
        binding.photosAlbumsToolbar.setNavigationOnClickListener {
            BostaCoordinator.back(this)
        }
        adapter = AlbumsPhotosAdapter {
            BostaCoordinator.navigate(PhotoZoomInOutDirection(this, it))
        }
    }


    override fun onStart() {
        super.onStart()
        binding.apply {
            album = vm.album
            photosRecyclerview.adapter = adapter
        }
        vm.loadPhotos()
        observeOn ()
    }

    private fun observeOn (){
        collect(vm.albumPhotos) {
            render(it)
        }
    }

    private fun render(it: Response) {
        when (it) {
            is Response.Loading -> {

            }
            is Response.Success<*> -> {
                adapter.submit(it.response as List<PhotosResponseItem>)
            }
            is Response.Error -> {
                Toaster.showError(this, "Fail Get Albums Because ${it.reason}")
            }
            else -> {
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        val item = menu.findItem(R.id.searchPhotos)
        SearchUtil.Builder(this).apply {
            setupSearchView(menuItem = item)
            setupListener(object : SearchUtil.SearchViewListener {
                override fun onSearchingStillRunning(searchText: String?) {
                    vm.searchPhotos(searchText ?: "")
                }

                override fun onSearchButtonClicked(searchText: String?) {

                }

                override fun onClearAllSearchText() {
                    vm.searchPhotos("")
                }
            })
        }
        return true
    }

}