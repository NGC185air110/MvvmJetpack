package com.example.mvvmjetpack.mvp

import java.util.*

/**
 * title：
 * description：
 * author：dinglicheng on 2021/9/27 16:45
 */
class MainModel : MainContract.Model {
    override fun getText(): Double {
        val rand = Random()
        val randomNum = rand.nextInt((100 - 1) + 1) + 1
        return randomNum.toDouble()
    }
}