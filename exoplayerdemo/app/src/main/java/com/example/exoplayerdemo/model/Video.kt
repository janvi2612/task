package com.example.exoplayerdemo.model


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("categories")
    var categories: List<Category>?
)
data class Category(
    @SerializedName("name")
    var name: String?,
    @SerializedName("videos")
    var videos: List<VideoX>?
)

data class VideoX(
    @SerializedName("description")
    var description: String?,
    @SerializedName("sources")
    var sources: List<String?>?,
    @SerializedName("subtitle")
    var subtitle: String?,
    @SerializedName("thumb")
    var thumb: String?,
    @SerializedName("title")
    var title: String?
)