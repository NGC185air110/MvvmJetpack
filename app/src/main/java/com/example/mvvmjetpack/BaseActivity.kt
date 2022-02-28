package com.example.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * title：
 * description：
 * author：dinglicheng on 2022/2/28 11:09
 */
abstract class BaseActivity<T : ViewBinding>(val inflater: (inflater: LayoutInflater) -> T) :
    AppCompatActivity() {

    protected lateinit var viewBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflater(layoutInflater)
        setContentView(viewBinding.root)
    }
}