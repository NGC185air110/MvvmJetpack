package com.example.mvvmjetpack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.mvvmjetpack.databinding.ActivityMain9Binding
import java.lang.reflect.Proxy

class MainActivity9 : BaseActivity<ActivityMain9Binding>(ActivityMain9Binding::inflate) {
    val TAG = "main9"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentList = arrayListOf<Fragment>()


        viewBinding.btn.setOnClickListener {
            var intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
            Log.d(TAG, "startActivity")
        }
    }

    override fun onNewIntent(intent: Intent?) {
        Log.d(TAG, "onNewIntent")
        super.onNewIntent(intent)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }


}