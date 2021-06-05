package com.example.aaidapsycholog.data.response

import com.google.gson.annotations.SerializedName

data class UserCaseResponse(

	@field:SerializedName("UserCaseResponse")
	val case: List<UserCaseResponseItem>
)

data class UserCaseResponseItem(

	@field:SerializedName("score")
	val score: Double,

	@field:SerializedName("twitter_user_id")
	val twitterUserId: Int,

	@field:SerializedName("tweet_id")
	val tweetId: Int,

	@field:SerializedName("owner_id")
	val ownerId: Int,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("created_date")
	val createdDate: String,

	@field:SerializedName("class")
	val jsonMemberClass: String,

	@field:SerializedName("is_claimed")
	val isClaimed: Boolean,

	@field:SerializedName("is_closed")
	val isClosed: Boolean
)
