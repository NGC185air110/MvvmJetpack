package com.example.mvvmjetpack.recyclerView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.LinearLayout

/**
 * title：
 * description：
 * author：dinglicheng on 2021/7/9 15:04
 */
class ObserverHScrollViewIntercept : LinearLayout {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }
}