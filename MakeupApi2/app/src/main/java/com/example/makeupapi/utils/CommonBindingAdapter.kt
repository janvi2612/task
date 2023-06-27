package com.example.makeupapi.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.example.makeupapi.R


@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, url: String){
    imageView.load(url){
        crossfade(true)
        placeholder(R.drawable.ic_baseline_image_24)
        error(R.drawable.ic_baseline_broken_image_24)
    }
}

@BindingAdapter("app:loadCircleImage")
fun loadCircleImage(imageView: ImageView, url: String){
    imageView.load(url){
        transformations(CircleCropTransformation())
        crossfade(true)
        placeholder(R.drawable.ic_baseline_image_24)
        error(R.drawable.ic_baseline_broken_image_24)
    }
}