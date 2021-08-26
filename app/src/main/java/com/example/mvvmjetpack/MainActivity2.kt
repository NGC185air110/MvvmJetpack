package com.example.mvvmjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.mvvmjetpack.databinding.ActivityMain2Binding
import com.example.mvvmjetpack.model.Goods
import kotlin.random.Random

@Route(path = "/test/bbb")
class MainActivity2 : AppCompatActivity() {
    var goods: Goods? = null
    var activityMain2Binding : ActivityMain2Binding? = null

    //livedata2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        activityMain2Binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this,R.layout.activity_main2)
        goods = Goods("code", "hi", 24)
        activityMain2Binding?.let { it.goods = goods }
        activityMain2Binding?.let { it.goodsHandler = GoodsHandler(goods) }
    }

    class GoodsHandler(var goods: Goods?) {

        fun changeGoodsName() {
            goods.let { it?.name = "code ${Random.nextInt(100)}" }
            goods.let { it?.price = Random.nextInt(100) }
        }

        fun changeGoodsDetails(){
            goods.let { it?.details = "hi ${Random.nextInt(100)}" }
            goods.let { it?.price = Random.nextInt(100) }
        }
    }
}
