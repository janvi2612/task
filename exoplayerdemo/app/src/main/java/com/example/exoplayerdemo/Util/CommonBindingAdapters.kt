package com.example.exoplayerdemo.Util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.exoplayerdemo.R


@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, url: String){
    imageView.load(url){
        crossfade(true)
        placeholder(R.drawable.ic_baseline_image_24)
        error(R.drawable.ic_baseline_broken_image_24)
    }
}

@BindingAdapter("app:loadImage")
fun loadVideo(imageViewvideo: ImageView, url: String){
    imageViewvideo.load(url){
        crossfade(true) }
}
