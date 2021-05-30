package com.example.mvvmjetpack

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmjetpack.viewmodel.MainActivity3ViewModel
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var tvTest: TextView = findViewById(R.id.tv_text)
        val viewModel: MainActivity3ViewModel by viewModels()
        viewModel.mCurrentText.observe(this, {
            tvTest.text = it
        })

        var btnSet: Button = findViewById(R.id.btn_set)
        btnSet.setOnClickListener {
            viewModel.login("uuuu${Random.nextInt(100)}","pppp${Random.nextInt(100)}")
        }
    }


}