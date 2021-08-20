package com.example.mvvmjetpack

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * title：
 * description：
 * author：dinglicheng on 2021/8/19 10:25
 */
class VpAdapter (
    private val mContext: Context,
    private var fmList: List<Fragment>,
    fm: androidx.fragment.app.FragmentManager,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fm, fragmentActivity.lifecycle) {
    override fun getItemCount(): Int {
        return fmList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fmList[position]
    }
}