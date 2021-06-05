package com.example.aaidapsycholog.data.response

import com.google.gson.annotations.SerializedName

data class TwitterUserResponse(
	@field:SerializedName("screen_name")
	val screenName: String,

	@field:SerializedName("id_str")
	val idStr: String,

	@field:SerializedName("profile_location")
	val profileLocation: Any,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("id")
	val id: Long
)
