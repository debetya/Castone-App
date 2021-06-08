package com.example.aaidapsycholog.ui.tweet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.repo.MainRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.reflect.Array
import javax.inject.Inject

@HiltViewModel
class CaseViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val listUserTweets = MutableLiveData<ArrayList<UserCaseResponseItem>>()

    fun getListTwitterUser(): MutableLiveData<ArrayList<UserCaseResponseItem>> {
        viewModelScope.launch {
            val csResponse: ArrayList<UserCaseResponseItem> = arrayListOf()
            when (val response = repository.getCaseUser()) {
                is Resource.Success -> {
                    response.data?.forEach { case ->
                        when (val twitterResponse = repository.getUserTwitter(case.twitterUserId)) {
                            is Resource.Success -> {
                                twitterResponse.data?.let { user ->
                                    when (val statusResponse = repository.getStatusTwitter(case.tweetId)){
                                        is Resource.Success -> {
                                            statusResponse.data?.let { status ->
                                                csResponse.add(UserCaseResponseItem(
                                                    case.score,
                                                    case.twitterUserId,
                                                    case.tweetId,
                                                    case.ownerId,
                                                    case.id,
                                                    case.createdDate,
                                                    case.jsonMemberClass,
                                                    case.isClaimed,
                                                    case.isClosed,
                                                    user.followersCount,
                                                    user.friendsCount,
                                                    status.text,
                                                    user.screenName,
                                                    user.name
                                                ))
                                            }
                                        }

                                        is Resource.Error -> {
                                            statusResponse.message
                                        }
                                    }
                                }
                            }
                            is Resource.Error -> {
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



