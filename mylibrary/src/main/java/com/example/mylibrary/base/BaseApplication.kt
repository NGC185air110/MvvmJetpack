package com.example.mylibrary.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.example.mylibrary.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        ARouter.openLog()   // 打印日志
        ARouter.openDebug() // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this) // 尽可能早，推荐在Application中初始化

        initLogger()
    }

    private fun initLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // 隐藏线程信息 默认：显示
            .methodCount(0)         // 决定打印多少行（每一行代表一个方法）默认：2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag("NewDriverHome")   // (Optional) Global tag for every log. Default PRETTY_LOGGER,设置TAG
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                if (BuildConfig.DEBUG) {
                    return true
                }
                return priority > Logger.DEBUG
            }
        })
    }
}