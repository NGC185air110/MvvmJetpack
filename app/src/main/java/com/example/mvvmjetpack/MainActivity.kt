package com.example.mvvmjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmjetpack.databinding.ActivityMainBinding
import com.example.mvvmjetpack.model.User
import com.example.mvvmjetpack.view.FragmentDilog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var user: User = User("dinglicheng", "123456")
        activityMainBinding.userInfo = user
        FragmentDilog().show(this.supportFragmentManager,"aaa")
    }
}