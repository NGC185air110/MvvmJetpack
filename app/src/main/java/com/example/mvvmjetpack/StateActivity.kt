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
        var btn7: Button = findViewById(R.id.btn_activity7)
        var btn9: Button = findViewById(R.id.btn_activity9)
        var btn10: Button = findViewById(R.id.btn_activity10)
        var btn11: Button = findViewById(R.id.btn_activity11)
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
        btn7.setOnClickListener {
            var intent = Intent(this, com.example.mvvmjetpack.MainActivity7::class.java)
            startActivity(intent)
        }
        btn9.setOnClickListener {
            var intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }
        btn10.setOnClickListener {
            var intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }
        btn11.setOnClickListener {
            var intent = Intent(this, MainActivity11::class.java)
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