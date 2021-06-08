package com.example.aaidapsycholog.data.response

data class UserDetailCaseResponse(
	val score: Double,
	val twitterUserId: String,
	val tweetId: Int,
	val ownerId: Int,
	val id: Int,
	val createdDate: String,
	val jsonMemberClass: String,
	val isClaimed: Boolean,
	val isClosed: Boolean
)

