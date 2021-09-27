package com.example.mvvmjetpack.mvp

/**
 * title：
 * description：
 * author：dinglicheng on 2021/9/27 16:45
 */
interface MainContract {
    interface View {
        fun setText(s: Double)
    }

    interface Presenter {
        fun text()
    }
    interface Model {
        fun getText(): Double
    }
}