package com.example.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * title：
 * description：
 * author：dinglicheng on 2022/2/28 11:21
 */
abstract class BaseFragment<T : ViewBinding>(private val inflater: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> T) :
    Fragment() {
    protected lateinit var viewBinding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = this.inflater(inflater, container, false)
        return viewBinding.root
    }
}