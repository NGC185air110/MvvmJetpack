package com.example.mvvmjetpack.view

import androidx.recyclerview.widget.RecyclerView

/**
 * title：
 * description：
 * author：dinglicheng on 2021/11/5 9:36
 */
class MyLinearManager : RecyclerView.LayoutManager() {
    private val LAYOUT_FINISH = -1
    private var adapterIndex = 0
    var gap = 5
        get() = field

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)

    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams =
        RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
}