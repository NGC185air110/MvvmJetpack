package com.example.mvvmjetpack

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmjetpack.databinding.ActivityTimerBinding
import com.example.mvvmjetpack.model.TimerViewModel

class TimerActivity : AppCompatActivity() {

    var binding: ActivityTimerBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutInflater.from(this).run {
            ActivityTimerBinding.inflate(this)
        }
        setContentView(binding?.root)
        iniComponent()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    fun iniComponent() {

        var timerViewModel: TimerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]
        timerViewModel.setLabelOnTimerChangeListener {
            runOnUiThread {
                binding?.tvTime?.text = "Time:$it"
            }
        }
        timerViewModel.startTiming()
    }
}