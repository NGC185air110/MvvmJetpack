package com.example.mvvmjetpack

import android.os.Bundle
import android.view.MotionEvent
import android.view.ViewGroup
import com.example.mvvmjetpack.databinding.ActivityMain12Binding
import com.example.mvvmjetpack.util.logd

class MainActivity12 : BaseActivity<ActivityMain12Binding>(ActivityMain12Binding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.view.setOnClickListener {
            "aaa".logd()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
           /* MotionEvent.ACTION_DOWN -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指按下".logd()
            }
            MotionEvent.ACTION_MOVE -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指滑动".logd()
            }
            MotionEvent.ACTION_UP -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指抬起".logd()
            }*/
        }
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            /*MotionEvent.ACTION_DOWN -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指按下".logd()
            }
            MotionEvent.ACTION_MOVE -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指滑动".logd()
            }
            MotionEvent.ACTION_UP -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指抬起".logd()
            }*/
        }
        return super.dispatchTouchEvent(ev)
    }
}