package com.example.mvvmjetpack

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmjetpack.mvp.MainActivity6
import com.example.mvvmjetpack.util.logd
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class StateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state)
        val btn1: Button = findViewById(R.id.btn_activity1)
        val btn2: Button = findViewById(R.id.btn_activity2)
        val btn3: Button = findViewById(R.id.btn_activity3)
        val btn4: Button = findViewById(R.id.btn_activity4)
        val btn5: Button = findViewById(R.id.btn_activity5)
        val btn6: Button = findViewById(R.id.btn_activity6)
        val btn7: Button = findViewById(R.id.btn_activity7)
        val btn9: Button = findViewById(R.id.btn_activity9)
        val btn10: Button = findViewById(R.id.btn_activity10)
        val btn11: Button = findViewById(R.id.btn_activity11)
        val btn12: Button = findViewById(R.id.btn_activity12)
        val mainViewGroup: LinearLayout = findViewById(R.id.ll_main)

        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }
        btn5.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
        btn6.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            startActivity(intent)
        }
        btn7.setOnClickListener {
            val intent = Intent(this, com.example.mvvmjetpack.MainActivity7::class.java)
            startActivity(intent)
        }
        btn9.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }
        btn10.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }
        btn11.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }
        btn12.setOnClickListener {
            val intent = Intent(this, MainActivity12::class.java)
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

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指按下".logd()
            }
            MotionEvent.ACTION_MOVE -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指滑动".logd()
            }
            MotionEvent.ACTION_UP -> {
                "Activity onTouchEvent  事件响应 是否消费 ${super.onTouchEvent(event)}  手指抬起".logd()
            }
        }
        //true 表示被消费其他位于此Activity上的事件返回上层调用
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指按下".logd()
            }
            MotionEvent.ACTION_MOVE -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指滑动".logd()
            }
            MotionEvent.ACTION_UP -> {
                "Activity dispatchTouchEvent 捕获到事件分发 ${super.dispatchTouchEvent(ev)}  手指抬起".logd()
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}