package com.example.aaidapsycholog.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aaidapsycholog.Resource
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailCaseViewModel @Inject constructor(private val repository: Repository) : ViewModel(){


}