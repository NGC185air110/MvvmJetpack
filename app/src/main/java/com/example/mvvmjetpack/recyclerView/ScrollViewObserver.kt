package com.example.mvvmjetpack.recyclerView

/**
 * title：
 * description：
 * author：dinglicheng on 2021/7/9 14:53
 */
class ScrollViewObserver {
    private var mList: ArrayList<OnScrollChangedListener>? = null

    constructor() : super() {
        mList = ArrayList()
    }

    fun addOnScrollChangedListener(listener: OnScrollChangedListener) {
        mList?.add(listener)
    }

    fun removeOnScrollChangedListener(listener: OnScrollChangedListener) {
        mList?.remove(listener)
    }

    fun notifyOnScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        if (mList == null || mList?.size == 0) {
            return
        }
        for (it in mList!!) {
            it.onScrollChanged(l, t, oldl, oldt)
        }
    }

    interface OnScrollChangedListener {
        fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int)
    }
}