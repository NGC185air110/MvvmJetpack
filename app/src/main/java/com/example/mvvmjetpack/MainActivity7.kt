package com.example.mvvmjetpack

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmjetpack.databinding.ActivityMain7Binding
import com.example.mvvmjetpack.view.FeedLayoutByDlc

class MainActivity7 : BaseActivity<ActivityMain7Binding>(ActivityMain7Binding::inflate) {
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        viewBinding.btnAdd

        var btnAdd = findViewById<Button>(R.id.btn_add)
        var feed = findViewById<FeedLayoutByDlc>(R.id.feed)
        btnAdd.setOnClickListener {
            //'构建TextView'
            TextView(this).apply {
                text = " Tag $index"
                textSize = 20f
                setBackgroundColor(Color.parseColor("#888888"))
                gravity = Gravity.CENTER
                setPadding(8, 3, 8, 3)
                setTextColor(Color.parseColor("#FFFFFF"))
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    rightMargin = 15
                    bottomMargin = 40
                }
                //'将TextView动态添加到容器控件container中'
            }.also { feed?.addView(it) }
            index++
        }
    }
}