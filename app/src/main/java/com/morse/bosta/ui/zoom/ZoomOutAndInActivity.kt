package com.morse.bosta.ui.zoom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ScaleGestureDetector
import androidx.activity.viewModels
import com.morse.bosta.R
import com.morse.bosta.app.BostaCoordinator
import com.morse.bosta.app.SharePhotoLinkDirection
import com.morse.bosta.databinding.ActivityZoomOutAndInBinding
import com.morse.bosta.utils.BaseActivity
import com.morse.bosta.utils.loadPicture
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Flow

@AndroidEntryPoint
class ZoomOutAndInActivity :
    BaseActivity<ActivityZoomOutAndInBinding>(R.layout.activity_zoom_out_and_in) {

    companion object {
        const val photoKey = "photoInformation"
    }
    private val vm by viewModels<ZoomViewModel>()
    private var scaleFactor: Float = 1.0F

    override fun onStart() {
        super.onStart()
        binding.photoImageView.loadPicture(vm.photo.url)
        configureActions()
    }


    private fun configureActions() {
        binding.sharePhotoLink.setOnClickListener {
            BostaCoordinator.navigate(SharePhotoLinkDirection(this, vm.photo))
        }
        binding.closeImageScreen.setOnClickListener {
            BostaCoordinator.back(this)
        }
    }

}