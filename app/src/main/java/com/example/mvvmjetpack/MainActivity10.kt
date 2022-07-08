package com.example.mvvmjetpack

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.mvvmjetpack.databinding.ActivityMain10Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

/**
 * title：
 * description：
 * author：dinglicheng on 2022/7/8 11:05
 */
class MainActivity10 : BaseActivity<ActivityMain10Binding>(ActivityMain10Binding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val job: Job = flow {
            for (i in 0..100) {
                emit(i)
                kotlinx.coroutines.delay(1000)
            }
        }.flowOn(Dispatchers.Default)
            .map { it + 100 }
            .onEach { viewBinding.btn.text = "计时(${it})" }
            .onCompletion { viewBinding.btn.text = "已经结束了" }
            .flowOn(Dispatchers.Main)
            .launchIn(lifecycleScope)


        viewBinding.btn.setOnClickListener {
            //关闭flow流
            job.cancel()
        }
    }
}