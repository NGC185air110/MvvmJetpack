package com.example.mvvmjetpack.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * title：
 * description：
 * author：dinglicheng on 2021/11/5 17:45
 */
class TagTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    private var textRect: Rect = Rect()
    private var textPaint: Paint = Paint()
    private var bgPaint: Paint = Paint()

    var tagTextSize: Float = 0F
        set(value) {
            field = value
            textPaint.textSize = value
        }
    var tagTextColor: Int = Color.parseColor("#FFFFFF")
        set(value) {
            field = value
            textPaint.color = value
        }

    var tagBgColor: Int = Color.parseColor("#FFFF5183")
        set(value) {
            field = value
            bgPaint.color = value
        }

    var tagTextTypeFace: Typeface? = null


}