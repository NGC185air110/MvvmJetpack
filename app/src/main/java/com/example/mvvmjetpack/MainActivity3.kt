package com.example.mvvmjetpack

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmjetpack.viewmodel.MainActivity3ViewModel
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {

    private val viewModel: MainActivity3ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val tvTest: TextView = findViewById(R.id.tv_text)
        //另一种创建方法
        //val viewModel: MainActivity3ViewModel = ViewModelProvider(this).get(MainActivity3ViewModel::class.java)

        viewModel.mCurrentText.observe(this, {
            tvTest.text = it
        })

        val btnSet: Button = findViewById(R.id.btn_set)
        btnSet.setOnClickListener {
            viewModel.login("uuuu${Random.nextInt(100)}", "pppp${Random.nextInt(100)}")
        }
    }


}