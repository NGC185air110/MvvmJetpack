package com.example.mvvmjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivity3ViewModel : ViewModel() {

    private val mCurrentTextPrivate:MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val mCurrentText: LiveData<String> get() = mCurrentTextPrivate


    fun login(userName: String, passWord: String) {
        viewModelScope.launch {  }
        mCurrentTextPrivate.value = "$userName+++++++++++++++++++++++++$passWord"
    }
}