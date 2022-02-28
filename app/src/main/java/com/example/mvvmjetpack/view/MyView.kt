package com.example.mvvmjetpack.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
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
    override fun onDraw(canvas: Canvas?) {//canvas 主体内容绘制
        super.onDraw(canvas)

        var paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.isAntiAlias = true
        paint.color = Color.BLACK

        canvas?.drawColor(Color.WHITE)
        canvas?.drawCircle(300f, 300f, 200f, Paint())


        var path = Path()
        paint.style = Paint.Style.STROKE//画线模式
        paint.strokeWidth = 10f//线的宽度
        path.addCircle(800f, 300f, 200f, Path.Direction.CW)
        canvas?.drawPath(path, paint)

        var path1 = Path()
        var paint1 = Paint()

        paint1.style = Paint.Style.FILL
        path1.fillType = Path.FillType.EVEN_ODD
        path1.addCircle(300f, 800f, 200f, Path.Direction.CW)
        path1.addCircle(600f, 800f, 200f, Path.Direction.CW)
        canvas?.drawPath(path1, paint1)


        paint.color = Color.BLUE
        canvas?.drawCircle(300f, 1200f, 200f, paint)

        var path2 = Path()
        var paint2 = Paint()
        paint2.color = Color.RED
        paint2.style = Paint.Style.FILL
        path2.fillType = Path.FillType.EVEN_ODD
        path2.addCircle(800f, 1200f, 200f, Path.Direction.CW)
        path2.addCircle(800f, 1200f, 100f, Path.Direction.CW)
        canvas?.drawPath(path2, paint2)
        paint1.textSize = 40f
        paint1.isAntiAlias = true
        canvas?.drawTextOnPath(
            "That there's some good in this world, and it's worth fighting for.",
            path2,
            0f,
            0f,
            paint1
        )

    }

}