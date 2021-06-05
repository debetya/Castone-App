package com.example.aaidapsycholog.repo

import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponse

interface Repository {
    suspend fun getCaseUser() : Resource<UserCaseResponse>
    suspend fun getUserTwitter(id:Int) : Resource<TwitterUserResponse>
}