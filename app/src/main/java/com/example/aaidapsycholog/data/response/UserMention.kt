package com.example.aaidapsycholog.data.response


import com.google.gson.annotations.SerializedName

data class UserMention(
    val id: Long?,
    @SerializedName("id_str")
    val idStr: String?,
    val indices: List<Int>?,
    val name: String?,
    @SerializedName("screen_name")
    val screenName: String?
)