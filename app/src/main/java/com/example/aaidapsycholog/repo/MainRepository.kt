package com.example.aaidapsycholog.repo


import com.example.aaidapsycholog.BuildConfig
import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.api.ApiService
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponse
import com.example.aaidapsycholog.utils.Constant
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService): Repository {


    override suspend fun getCaseUser(): Resource<UserCaseResponse> {
        apiService.getUserCase().let { response ->
            if (response.isSuccessful){
                response.body()?.let { case ->
                    return Resource.Success(case)
                }
            }
            return Resource.Error(response.message())
        }
    }

    override suspend fun getUserTwitter(id: Int): Resource<TwitterUserResponse> {
        apiService.getTwitterUser(Constant.BASE_URL_TWITTER+"=$id", BuildConfig.BEARER_TOKEN,)
            .let { response ->
                if (response.isSuccessful){
                    response.body()?.let { name ->
                        return Resource.Success(name)
                    }
                }
                return Resource.Error(response.message())
            }
    }


}
