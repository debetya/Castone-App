package com.example.aaidapsycholog.repo


import android.util.Log
import com.example.aaidapsycholog.BuildConfig
import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.api.ApiService
import com.example.aaidapsycholog.data.response.*
import com.example.aaidapsycholog.utils.Constant
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCaseUser(): Resource<ArrayList<UserCaseResponseItem>> {
        apiService.getUserCase().let { response ->
            if (response.isSuccessful){
                response.body()?.let { test ->
                    return Resource.Success(test)
                }
            }
            return Resource.Error(response.message())
        }
    }

    suspend fun getUserTwitter(id: String): Resource<TwitterUserResponse> {
        apiService.getTwitterUser("Bearer ${BuildConfig.BEARER_TOKEN}", "${Constant.BASE_URL_TWITTER}users/show.json?user_id=$id")
            .let { response ->
                if (response.isSuccessful){
                    response.body()?.let { name ->
                        return Resource.Success(name)
                    }
                }
                return Resource.Error(response.message())
            }
    }

    suspend fun getStatusTwitter(id: String): Resource<UserStatusResponse> {
        apiService.getStatusUser("Bearer ${BuildConfig.BEARER_TOKEN}", "${Constant.BASE_URL_TWITTER}statuses/show.json?id=$id")
            .let { response ->
                if (response.isSuccessful){
                    response.body()?.let { text ->
                        return Resource.Success(text)
                    }
                }
                return Resource.Error(response.message())
            }
    }

}
