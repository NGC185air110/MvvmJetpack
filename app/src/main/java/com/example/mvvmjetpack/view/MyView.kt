package com.example.mvvmjetpack.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * title：
 * description：
 * author：dinglicheng on 2021/11/5 10:03
 */
class MyView : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    //画多大
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)


        //告诉他画多大，这个函数为画多大的终点
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    //画在哪
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    //怎么画
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}