package com.morse.bosta.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.morse.bosta.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

@BindingAdapter("setName")
fun AppCompatTextView.setName(name: String) {
    text = context.getString(R.string.helloMessage, name)
}

@BindingAdapter("loadImage")
fun AppCompatImageView.loadImage(url: String) {
    Picasso.get().load(url)
        .transform(CropCircleTransformation())
        .placeholder(R.drawable.ic_user_individual_avatar)
        .error(R.drawable.ic_user_individual_avatar)
        .into(this)
}

@BindingAdapter("loadPhoto")
fun AppCompatImageView.loadPhoto(url: String) {
    Picasso.get().load(url)
        .transform(RoundedCornersTransformation(resources.getDimension(R.dimen._10sdp).toInt() , 0))
        .placeholder(R.drawable.ic_user_individual_avatar)
        .error(R.drawable.ic_user_individual_avatar)
        .into(this)
}
