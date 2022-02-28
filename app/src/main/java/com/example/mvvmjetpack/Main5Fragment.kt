package com.example.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmjetpack.databinding.FragmentMain5Binding

/**
 * title：
 * description：
 * author：dinglicheng on 2021/8/19 9:47
 */
class Main5Fragment(var s: String) :
    BaseFragment<FragmentMain5Binding>(FragmentMain5Binding::inflate) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflaters = inflater.inflate(R.layout.fragment_main5, container, false)
        fragmentList.add(BlankFragment("$s aaa"))
        fragmentList.add(BlankFragment("$s bbb"))
        fragmentList.add(BlankFragment("$s ccc"))
        fragmentList.add(BlankFragment("$s ddd"))
        fragmentList.add(BlankFragment("$s eee"))
        var vp_main: ViewPager2 = inflaters.findViewById(R.id.vp_main)
        vp_main.adapter = TapAdapter(this, fragmentList)
        return inflaters
    }
}