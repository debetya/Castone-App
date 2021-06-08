package com.example.aaidapsycholog.data.response


import com.google.gson.annotations.SerializedName

data class Status(
    val contributors: Any?,
    val coordinates: Any?,
    @SerializedName("created_at")
    val createdAt: String?,
    val entities: EntitiesX?,
    @SerializedName("favorite_count")
    val favoriteCount: Int?,
    val favorited: Boolean?,
    val geo: Any?,
    val id: Long?,
    @SerializedName("id_str")
    val idStr: String?,
    @SerializedName("in_reply_to_screen_name")
    val inReplyToScreenName: String?,
    @SerializedName("in_reply_to_status_id")
    val inReplyToStatusId: Long?,
    @SerializedName("in_reply_to_status_id_str")
    val inReplyToStatusIdStr: String?,
    @SerializedName("in_reply_to_user_id")
    val inReplyToUserId: Long?,
    @SerializedName("in_reply_to_user_id_str")
    val inReplyToUserIdStr: String?,
    @SerializedName("is_quote_status")
    val isQuoteStatus: Boolean?,
    val lang: String?,
    val place: Any?,
    @SerializedName("retweet_count")
    val retweetCount: Int?,
    val retweeted: Boolean?,
    val source: String?,
    val text: String?,
    val truncated: Boolean?
)