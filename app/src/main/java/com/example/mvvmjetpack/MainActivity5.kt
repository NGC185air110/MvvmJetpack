package com.example.mvvmjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class MainActivity5 : AppCompatActivity() {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        fragmentList.add(Main5Fragment("1"))
        fragmentList.add(Main5Fragment("2"))
        var vp_main: ViewPager2 = findViewById(R.id.vp_main)
        vp_main.adapter = VpAdapter(this, fragmentList, supportFragmentManager, this)
    }
}