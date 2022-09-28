package com.example.mvvmjetpack.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import com.example.mvvmjetpack.util.logd

class FrameLayoutMain1 : FrameLayout {

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
        "拦截不透出".logd()
        return true
    }

    //是否决定消费
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        "消费完毕".logd()
        return true
    }

}