package com.example.mvvmjetpack.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmjetpack.BlankFragment
import com.example.mvvmjetpack.R
import com.example.mvvmjetpack.TapAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentDilog : DialogFragment() {
    var mLayoutView: View? = null
    lateinit var tab_layout: TabLayout
    lateinit var vp_main: ViewPager2
    private val titles = arrayOf("1", "2", "3", "4", "5")
    private val fragmentList: ArrayList<Fragment> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mLayoutView = inflater.inflate(R.layout.dialog_main, container)
        viewHolders(mLayoutView!!)

        fragmentList.add(BlankFragment("aaa"))
        fragmentList.add(BlankFragment("bbb"))
        fragmentList.add(BlankFragment("ccc"))
        fragmentList.add(BlankFragment("ddd"))
        fragmentList.add(BlankFragment("eee"))

        vp_main.adapter = TapAdapter(this, fragmentList)
        TabLayoutMediator(
            tab_layout, vp_main
        ) { tab, position -> tab.text = titles[position] }.attach()
        return mLayoutView
    }


    fun viewHolders(mLayoutView: View) {
        tab_layout = mLayoutView.findViewById(R.id.tab_layout)
        vp_main = mLayoutView.findViewById(R.id.vp_main)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var attributes: WindowManager.LayoutParams = dialog!!.window!!.attributes
        attributes.width = 800
        attributes.height = 800
        dialog!!.window!!.attributes = attributes
    }

}