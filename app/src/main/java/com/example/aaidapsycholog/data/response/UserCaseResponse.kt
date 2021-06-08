package com.example.aaidapsycholog.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class UserCaseResponse(

	@field:SerializedName("UserCaseResponse")
	val case: ArrayList<UserCaseResponseItem>,
	@field:SerializedName("TwitterUserResponse")
	val tw: TwitterUserResponse? = null

)

@Parcelize
data class UserCaseResponseItem(

	@field:SerializedName("score")
	val score: Double,

	@field:SerializedName("twitter_user_id")
	val twitterUserId: String,

	@field:SerializedName("tweet_id")
	val tweetId: String,

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
	val isClosed: Boolean,

	val followers: Int?,

	val following: Int?,

	val tweet: String?,

	val screenName: String?,

	val name: String?

): Parcelable
