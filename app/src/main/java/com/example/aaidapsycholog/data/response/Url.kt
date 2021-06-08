package com.example.aaidapsycholog.data.response


import com.google.gson.annotations.SerializedName

data class Url(
    @SerializedName("display_url")
    val displayUrl: String?,
    @SerializedName("expanded_url")
    val expandedUrl: String?,
    val indices: List<Int>?,
    val url: String?
)