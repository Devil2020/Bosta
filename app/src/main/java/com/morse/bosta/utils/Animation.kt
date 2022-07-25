package com.morse.bosta.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.Interpolator


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