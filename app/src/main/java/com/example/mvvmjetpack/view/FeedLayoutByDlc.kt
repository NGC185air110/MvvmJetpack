package com.example.mvvmjetpack.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

/**
 * title：
 * description：
 * author：dinglicheng on 2021/11/5 10:09
 */
class FeedLayoutByDlc : ViewGroup {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )


    //横向间距
    private var horizontalGap: Int = 0

    //竖向间距
    private var verticalGap: Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        //获取容器高度模式
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        //获取容器的宽度
        val width = MeasureSpec.getSize(widthMeasureSpec)
        //容器高度初始为0
        var height = 0
        //如果高度模式是match_parent高度就是最大，如果不是那就几行累加
        if (heightMode == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec)
        } else {
            //还剩下的空间
            var remainWidth = width
            (0 until childCount).map { getChildAt(it) }.forEach { child ->
                val lp = child.layoutParams as MarginLayoutParams
                if (isNewLine(lp, child, remainWidth, horizontalGap)) {//换行
                    remainWidth = width - child.measuredWidth
                    height += (lp.topMargin + lp.bottomMargin + child.measuredHeight + verticalGap)
                } else {//不换行
                    remainWidth -= child.measuredWidth
                    if (height == 0) {
                        height =
                            (lp.topMargin + lp.bottomMargin + child.measuredHeight + verticalGap)
                    }
                }
                remainWidth -= (lp.leftMargin + lp.rightMargin + horizontalGap)
            }
        }
        setMeasuredDimension(width, height)
    }

    private fun isNewLine(
        lp: MarginLayoutParams,
        child: View,
        remainWidth: Int,
        horizontalGap: Int
    ): Boolean {
        //控件的整体宽度
        val childOccupation = lp.leftMargin + child.measuredWidth + lp.rightMargin
        //控件整体宽度+设定的横向间距>剩下的间距 并且 控件整体宽度>剩下间距 避免设定间距过大的问题
        //true就是得换行
        return (childOccupation + horizontalGap > remainWidth) && (childOccupation > remainWidth)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //确定坐标系
        var left = 0
        var top = 0
        var lastBottom = 0
        (0 until childCount).map { getChildAt(it) }.forEach { child ->
            val lp = child.layoutParams as MarginLayoutParams
            if (isNewLine(lp, child, r - l - left, horizontalGap)) {
                left = -lp.leftMargin
                top = lastBottom
                lastBottom = 0
            }
            val childLeft = left + lp.leftMargin
            val childTop = top + lp.topMargin
            child.layout(
                childLeft,
                childTop,
                childLeft + child.measuredWidth,
                childTop + child.measuredHeight
            )
            if (lastBottom == 0) {
                lastBottom = child.bottom + lp.bottomMargin + verticalGap
            }
            left += child.measuredWidth + lp.leftMargin + lp.rightMargin + horizontalGap
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}