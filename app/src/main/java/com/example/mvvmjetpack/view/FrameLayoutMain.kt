package com.example.mvvmjetpack.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.example.mvvmjetpack.util.logd

class FrameLayoutMain : FrameLayout {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    //是否决定拦截
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        "未处理不拦截  ${this.id}".logd()
        return super.onInterceptTouchEvent(ev)
    }

    //是否决定消费
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        "未处理不消费 ${this.id}".logd()
        return super.onTouchEvent(event)
    }

}