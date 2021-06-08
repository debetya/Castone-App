package com.example.aaidapsycholog.data.api

import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserDetailCaseResponse
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.data.response.UserStatusResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("profile/cases")
    suspend fun getUserCase() : Response<ArrayList<UserCaseResponseItem>>

    @GET
    suspend fun getTwitterUser(
        @Header("Authorization") bearer:String,
        @Url url:String,
    ) : Response<TwitterUserResponse>

    @GET
    suspend fun getStatusUser(
        @Header("Authorization") bearer:String,
        @Url url:String,
    ) : Response<UserStatusResponse>

}