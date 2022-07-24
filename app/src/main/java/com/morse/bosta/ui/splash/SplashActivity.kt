package com.morse.bosta.ui.splash

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.Interpolator
import androidx.core.animation.addListener
import androidx.databinding.DataBindingUtil
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.morse.bosta.BuildConfig
import com.morse.bosta.R
import com.morse.bosta.app.BostaCoordinator
import com.morse.bosta.app.ProfileDirection
import com.morse.bosta.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    var binding: ActivitySplashBinding? = null
    val list: List<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        binding?.apply {
            arabicName = BuildConfig.RIGHT
            englishName = BuildConfig.LEFT
        }
        animateApplicationName()
    }

    private fun animateApplicationName() {
        animateArabicWord {
            animateScaleBigDot()
            animateScaleAndTranslateSmallDot {
                animateAttentionRuppered {
                    navigate()
                }
            }
        }
        animateEnglishWord()
    }

    private inline fun animateAttentionRuppered(crossinline doOnEnd: (Animator) -> Unit) {
        val animatorSet = AnimatorSet()
        val object1: ObjectAnimator =
            ObjectAnimator.ofFloat(
                binding?.rotateCirculeImageView,
                "scaleX",
                1f,
                1.25f,
                0.75f,
                1.15f,
                1f
            )
        val object2: ObjectAnimator =
            ObjectAnimator.ofFloat(
                binding?.rotateCirculeImageView,
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
        binding?.arabicApplicationName?.animateView(R.anim.enter_arabic_word)
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
        binding?.englishApplicationName?.animateView(R.anim.enter_english_word)
            .run()
    }

    private fun animateScaleBigDot() {
        binding?.scaleCirculeImageView?.animateView(R.anim.bounce_scale)
            .setInterpolator(BounceInterpolator())
            .setUpListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                    binding?.scaleCirculeImageView?.alpha = 1f

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
        val object1 = ObjectAnimator.ofFloat(binding?.rotateCirculeImageView, "alpha", 0f, 1f)
        val object2 = ObjectAnimator.ofFloat(
            binding?.rotateCirculeImageView,
            "translationY",
            bottom,
            0f,
            -310f
        )
        val object3 = ObjectAnimator.ofFloat(
            binding?.rotateCirculeImageView,
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

    private fun navigate() {
        BostaCoordinator.navigateAfter(direction = ProfileDirection(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}

fun View?.animateView(animationRes: Int): View? {
    this?.animation = AnimationUtils.loadAnimation(this?.context, animationRes)
    return this
}

fun View?.setUpListener(listener: Animation.AnimationListener? = null): View? {
    this?.animation?.setAnimationListener(listener)
    return this
}

fun View?.setInterpolator(inter: Interpolator? = null): View? {
    this?.animation?.interpolator = inter
    return this
}

fun View?.run() = this?.animation?.startNow()