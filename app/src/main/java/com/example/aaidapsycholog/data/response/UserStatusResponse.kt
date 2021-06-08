package com.example.aaidapsycholog.data.response

import com.google.gson.annotations.SerializedName

data class UserStatusResponse(

    @field:SerializedName("entities")
    val entities: Entities,

    @field:SerializedName("id_str")
    val idStr: String,

    @field:SerializedName("created_at")
    val createdAt: String,

    @field:SerializedName("truncated")
    val truncated: Boolean,

    @field:SerializedName("id")
    val id: Long,

    @field:SerializedName("text")
    val text: String
)