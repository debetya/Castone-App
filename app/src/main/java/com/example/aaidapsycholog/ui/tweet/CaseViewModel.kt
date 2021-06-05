package com.example.aaidapsycholog.ui.tweet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.repo.MainRepository
import com.example.aaidapsycholog.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CaseViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val listUserTweets = MutableLiveData<ArrayList<TwitterUserResponse>>()

    fun getListTwitterUser(): MutableLiveData<ArrayList<TwitterUserResponse>>{
        viewModelScope.launch {
            val csResponse: ArrayList<TwitterUserResponse> = arrayListOf()
            when (val response = repository.getCaseUser()){
                is Resource.Success -> {
                    response.data?.case?.forEach {
                        when (val twitterResponse = repository.getUserTwitter(it.twitterUserId)){
                            is Resource.Success ->{
                                twitterResponse.data?.let {
                                    csResponse.add(it)
                                }
                            }
                            is Resource.Error ->{
                                twitterResponse.message
                            }
                        }
                    }
                    listUserTweets.postValue(csResponse)
                }
                is Resource.Error -> {
                    response.message
                }
            }
        }
        return listUserTweets
    }
}