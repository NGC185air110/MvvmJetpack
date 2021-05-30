package com.example.mvvmjetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivity3ViewModel constructor() : ViewModel() {

    private var mCurrentTextPrivate = MutableLiveData<String>()
    val mCurrentText: LiveData<String> get() = mCurrentTextPrivate


    fun login(userName: String, passWord: String) {
        mCurrentTextPrivate.value = "$userName+++++++++++++++++++++++++$passWord"
    }
}