package com.example.mvvmjetpack.recyclerView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.HorizontalScrollView

/**
 * title：
 * description：
 * author：dinglicheng on 2021/7/9 14:51
 */
class ObserverHScrollView : HorizontalScrollView {

    var mScrollViewObserver: ScrollViewObserver = ScrollViewObserver()

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(ev)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        if (mScrollViewObserver != null) {
            mScrollViewObserver.notifyOnScrollChanged(l, t, oldl, oldt)
        }
        super.onScrollChanged(l, t, oldl, oldt)
    }

    fun addOnScrollChangedListener(listener: ScrollViewObserver.OnScrollChangedListener) {
        mScrollViewObserver.addOnScrollChangedListener(listener)
    }

    fun removeOnScrollChangedListener(listener: ScrollViewObserver.OnScrollChangedListener) {
        mScrollViewObserver.removeOnScrollChangedListener(listener)
    }
}