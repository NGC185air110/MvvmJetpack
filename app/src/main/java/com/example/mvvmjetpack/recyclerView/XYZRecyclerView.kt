package com.example.mvvmjetpack.recyclerView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 * title：
 * description：
 * author：dinglicheng on 2021/7/9 13:58
 */
class XYZRecyclerView : RecyclerView {
    private var mTouchSlop: Int = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        val vc: ViewConfiguration = ViewConfiguration.get(getContext())
        mTouchSlop = vc.scaledTouchSlop
    }

    var x1: Float = 0f
    var x2: Float = 0f
    var y1: Float = 0f
    var y2: Float = 0f
    var mHorizontalScrollView: HorizontalScrollView? = null
    fun setHorizontalScrollView(horizontalScrollView: HorizontalScrollView?) {
        mHorizontalScrollView = horizontalScrollView
        setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                x1 = event.x
                y1 = event.y
                mHorizontalScrollView?.onTouchEvent(event)
            }
            if (event.action == MotionEvent.ACTION_MOVE) {
                x2 = event.x
                y2 = event.y
                if (abs(x1 - x2) - abs(y1 - y2) > mTouchSlop) {
                    mHorizontalScrollView?.onTouchEvent(event)
                    return@setOnTouchListener true//消费了
                }
            }
            if (event.action == MotionEvent.ACTION_UP) {
                x2 = event.x
                y2 = event.y
                if (abs(x1 - x2) - abs(y1 - y2) > mTouchSlop) {
                    mHorizontalScrollView?.onTouchEvent(event)
                    return@setOnTouchListener true//消费了
                }
            }
            return@setOnTouchListener false
        }
    }
}