package com.example.mvvmjetpack.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import java.util.*

/**
 * title：
 * description：
 * author：dinglicheng on 2021/11/2 14:44
 */
class TimerViewModel(private val myContext: Application) : AndroidViewModel(myContext) {
    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

    var timer: Timer? = null
    var currentSecond: Int = 0
    var onTimerChangeListener: ((a: Int) -> Unit)? = null

    private val mCurrentTextPrivate: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val mCurrentText: LiveData<Int> get() = mCurrentTextPrivate

    fun setLabelOnTimerChangeListener(onChick: (a: Int) -> Unit) {
        this.onTimerChangeListener = onChick
    }

    fun startTiming() {
        //当viewModel取消的时候下面代码自动回收
        viewModelScope.launch {
            if (timer == null) {
                currentSecond = 0
                timer = Timer()
                var timerTask = object : TimerTask() {
                    override fun run() {
                        currentSecond++
                        mCurrentTextPrivate.postValue(currentSecond)//在线程里需要使用post不然就可以直接用set
                        onTimerChangeListener?.invoke(currentSecond)
                        Log.d("context", "----------是--$myContext")
                    }
                }
                timer!!.schedule(timerTask, 1000, 1000)
            }
        }
        LinearLayoutManager(myContext)

    }


}