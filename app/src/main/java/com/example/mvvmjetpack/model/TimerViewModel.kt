package com.example.mvvmjetpack.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
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

    fun setLabelOnTimerChangeListener(onChick: (a: Int) -> Unit) {
        this.onTimerChangeListener = onChick
    }

    fun startTiming() {
        if (timer == null) {
            currentSecond = 0
            timer = Timer()
            var timerTask = object : TimerTask() {
                override fun run() {
                    currentSecond++
                    onTimerChangeListener?.invoke(currentSecond)
                    Log.d("context","----------是--$myContext")
                }
            }
            timer!!.schedule(timerTask, 1000, 1000)
        }
    }


}