package com.example.mvvmjetpack.mvp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmjetpack.R

/**
 * title：
 * description：
 * author：dinglicheng on 2021/9/27 16:44
 */

class MainActivity6 : AppCompatActivity(), MainContract.View {

    private val mPresenter: MainPresenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        mPresenter.text()
    }

    override fun setText(s: Double) {
        val text: TextView = findViewById(R.id.tv_text)
        text.text = s.toString()
    }
}