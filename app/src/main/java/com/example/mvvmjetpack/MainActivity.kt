package com.example.mvvmjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mvvmjetpack.databinding.ActivityMainBinding
import com.example.mvvmjetpack.model.User

@Route(path = "/test/aaa")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var user: User = User("dinglicheng", "123456")
        activityMainBinding.userInfo = user
        //FragmentDilog().show(this.supportFragmentManager,"aaa")
        //我的Android studio 为什么没有pull
        ARouter.getInstance().build("/test/bbb").navigation()
        activityMainBinding.btnGo.setOnClickListener { ARouter.getInstance().build("/test/bbb").navigation() }
    }
}
