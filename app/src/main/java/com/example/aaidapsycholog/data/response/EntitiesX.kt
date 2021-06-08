package com.example.aaidapsycholog.data.response


import com.google.gson.annotations.SerializedName

data class EntitiesX(
    val hashtags: List<Any>?,
    val symbols: List<Any>?,
    val urls: List<Url>?,
    @SerializedName("user_mentions")
    val userMentions: List<UserMention>?
)