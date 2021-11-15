package com.example.mvvmjetpack

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmjetpack.databinding.ActivityTimerBinding
import com.example.mvvmjetpack.model.TimerViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap
import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TimerActivity : AppCompatActivity() {

    var binding: ActivityTimerBinding? = null

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutInflater.from(this).run {
            ActivityTimerBinding.inflate(this)
        }
        setContentView(binding?.root)
        iniComponent()
        main()
        playLOL()
        main1()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun iniComponent() {
        //两种初始viewModel的方法
        val timerViewModel: TimerViewModel by viewModels()
        //var timerViewModel: TimerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]
        timerViewModel.setLabelOnTimerChangeListener {
            runOnUiThread {
                binding?.tvTime?.text = "Time:$it"
            }
        }
        timerViewModel.mCurrentText.observe(this) {}
        timerViewModel.mCurrentText.observe(this, {
            binding?.tvTime1?.text = "liveData:time:$it"
        })
        timerViewModel.startTiming()
    }

    //类委托
    interface Base {
        fun text()
    }

    //被委托的类(真实的类)
    class BaseImpl(private val x: String) : Base {
        override fun text() {
            Log.d("代理类", "$x")
        }
    }

    //委托类（代理类）代练上线
    class Devices(b: Base) : Base by b

    private fun main() {
        var b = BaseImpl("我是类")
        Devices(b).text()
    }

    /*-------------------------------*/
    //游戏和游戏内容
    interface LOL {
        fun rank()
    }

    //电脑开始
    class MyComputer(private val s: String) : LOL {
        override fun rank() {
            Log.d("TGP", "电脑打开LOL开始上分---$s")
        }

        fun kill() {
            Log.d("TGP", "我手感很好开始乱杀---$s")
        }
    }

    class GameLevelingComputer(private val s: String) : LOL {
        override fun rank() {
            Log.d("TGP", "电脑打开LOL开始上分---$s")
        }
    }

    //代练
    /* class GameLevelingComputer(play: MyComputer) : LOL by play*/

    private fun playLOL() {
        GameLevelingComputer("代练用我的电脑开始LOL").rank()
        MyComputer("我自己来LOL").rank()
        MyComputer("我自己来").kill()
    }


    //----------------------------属性委托------------------------------

    class B {
        //委托属性
        var a: String by Text()
    }

    //被委托类（真实类）
    class Text {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "属性拥有者 = $thisRef, 属性的名字 = '${property.name}' 属性的值 "
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            Log.d("TGP", "属性的值 = $value 属性的名字 =  '${property.name}' 属性拥有者 =  $thisRef")
        }
    }

    @InternalCoroutinesApi
    private fun main1() {
        var b = B()
        Log.d("TGP", "${b.a}")
        b.a = "ababab"

        val c: String by Text1()
        val d: String by Text2()

        var lazy = Lazy()
        lazy.a = "臭弟弟一拳"
        lazy.a = "臭弟弟两拳"

        Log.d("TGP", "$data")
        data = 100
        Log.d("TGP", "$data")

        /*var map = ConcurrentHashMap<Any, Any>()
        for (index in 0 until 1000) {
            var thread0 = HashMapThread(map, "线程名1:$index")
            thread0.start()
            var thread1 = HashMapThread(map, "线程名2:$index")
            thread1.start()
        }*/

        lifecycleScope.launch {
            flow<Int> { emit(1) }.collect(object : FlowCollector<Int> {
                override suspend fun emit(value: Int) {
                }
            })
        }
    }

    //更快的实现属性委托类
    class Text1 : ReadOnlyProperty<Any?, String> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "属性拥有者 = $thisRef, 属性的名字 = '${property.name}' 属性的值 "
        }
    }

    class Text2 : ReadWriteProperty<Any?, String> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "属性拥有者 = $thisRef, 属性的名字 = '${property.name}' 属性的值 "
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            Log.d("TGP", "属性的值 = $value 属性的名字 =  '${property.name}' 属性拥有者 =  $thisRef")
        }
    }

    //监听者弟
    class Lazy {
        var a: String by Delegates.observable("初始弟弟") { _, oldValue, newValue ->
            Log.d("TGP", "$oldValue -> $newValue")
        }
    }

    //扩展 field幕后字段放置直接调用自己的代码出现内存溢出错误
    private var data: Int = 0
        set(value) {
            Log.d("TGP", "--------$value")
            field = value
        }

    //ConcurrentHashMap和HashMap相互替换
    class HashMapThread(var map: ConcurrentHashMap<Any, Any>, name: String) : Thread() {

        override fun run() {
            var i = Math.random() * 100000
            map["键$i"] = "值$i"
            map.remove("键$i")
            Log.d("TGP", "${this.name}map的大小${map.size}")
        }
    }
}