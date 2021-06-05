package com.example.aaidapsycholog.data.api

import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("profile/case")
    suspend fun getUserCase() : Response<UserCaseResponse>

    @GET
    suspend fun getTwitterUser(
        @Url url: String,
        @Header("Authorization") bearer:String,
    ) : Response<TwitterUserResponse>

}