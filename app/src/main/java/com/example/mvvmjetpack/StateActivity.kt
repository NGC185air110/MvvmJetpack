package com.example.mvvmjetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmjetpack.mvp.MainActivity6
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class StateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state)
        var btn1: Button = findViewById(R.id.btn_activity1)
        var btn2: Button = findViewById(R.id.btn_activity2)
        var btn3: Button = findViewById(R.id.btn_activity3)
        var btn4: Button = findViewById(R.id.btn_activity4)
        var btn5: Button = findViewById(R.id.btn_activity5)
        var btn6: Button = findViewById(R.id.btn_activity6)
        btn1.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            var intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            var intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            var intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            var intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }


        val testFloat = flow<String> {
            emit("hello")
            emit("flow")
        }
        GlobalScope.launch {
            testFloat.collect { value -> println("$value+++++++++++++++++++++") }
        }

    }
}