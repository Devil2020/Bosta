package com.morse.bosta.ui.splash

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import androidx.activity.viewModels
import androidx.core.animation.addListener
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.morse.bosta.BuildConfig
import com.morse.bosta.R
import com.morse.bosta.app.BostaCoordinator
import com.morse.bosta.app.ProfileDirection
import com.morse.bosta.data.UserResponseItem
import com.morse.bosta.databinding.ActivitySplashBinding
import com.morse.bosta.utils.*
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    
    private val vm by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            arabicName = BuildConfig.RIGHT
            englishName = BuildConfig.LEFT
        }
        animateApplicationName()
    }

    override fun onStart() {
        super.onStart()
        collect(vm.user) {
            when (it) {
                is Response.Success<*> -> {
                    val user = it.response as UserResponseItem
                    navigate(user)
                }
                is Response.Error -> {
                    Toaster.showError(this, "Fail Load User Information , Because ${it.reason}")
                }
                else -> {}
            }
        }
    }

    private fun animateApplicationName() {
        animateArabicWord {
            animateScaleBigDot()
            animateScaleAndTranslateSmallDot {
                animateAttentionRuppered {}
            }
        }
        animateEnglishWord()
    }

    private inline fun animateAttentionRuppered(crossinline doOnEnd: (Animator) -> Unit) {
        val animatorSet = AnimatorSet()
        val object1: ObjectAnimator =
            ObjectAnimator.ofFloat(
                binding.rotateCirculeImageView,
                "scaleX",
                1f,
                1.25f,
                0.75f,
                1.15f,
                1f
            )
        val object2: ObjectAnimator =
            ObjectAnimator.ofFloat(
                binding.rotateCirculeImageView,
                "scaleY",
                1f,
                0.75f,
                1.25f,
                0.85f,
                1f
            )
        animatorSet.playTogether(object1, object2)
        with(animatorSet) {
            duration = 1000
            interpolator = FastOutSlowInInterpolator()
            addListener(onEnd = doOnEnd)
            this.start()
        }
    }

    private inline fun animateArabicWord(crossinline doOnEnd: () -> Unit) {
        binding.arabicApplicationName.animateView(R.anim.enter_arabic_word)
            .setUpListener(object : Animation.AnimationListener {

                override fun onAnimationRepeat(p0: Animation?) {

                }

                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    doOnEnd.invoke()
                }
            })
            .run()
    }

    private fun animateEnglishWord() {
        binding.englishApplicationName.animateView(R.anim.enter_english_word)
            .run()
    }

    private fun animateScaleBigDot() {
        binding.scaleCirculeImageView.animateView(R.anim.bounce_scale)
            .setInterpolator(BounceInterpolator())
            .setUpListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                    binding.scaleCirculeImageView.alpha = 1f

                }

                override fun onAnimationEnd(p0: Animation?) {

                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            .run()
    }

    private inline fun animateScaleAndTranslateSmallDot(crossinline doOnEnd: (Animator) -> Unit) {
        val bottom = 0F
        val right = 0F
        val animatorSet = AnimatorSet()
        val object1 = ObjectAnimator.ofFloat(binding.rotateCirculeImageView, "alpha", 0f, 1f)
        val object2 = ObjectAnimator.ofFloat(
            binding.rotateCirculeImageView,
            "translationY",
            bottom,
            0f,
            -310f
        )
        val object3 = ObjectAnimator.ofFloat(
            binding.rotateCirculeImageView,
            "translationX",
            right,
            0f,
            -310f
        )
        animatorSet.playTogether(object1, object2, object3)

        with(animatorSet) {
            duration = 1000
            interpolator = FastOutSlowInInterpolator()
            addListener(onEnd = doOnEnd)
            this.start()
        }
    }

    private fun navigate(user: UserResponseItem) {
        BostaCoordinator.navigateAfter( time = 2500L , direction = ProfileDirection(this, user))
    }
    
}