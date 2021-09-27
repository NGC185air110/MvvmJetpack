package com.example.mvvmjetpack.mvp

/**
 * title：
 * description：
 * author：dinglicheng on 2021/9/27 16:44
 */
class MainPresenter(var view: MainContract.View) : MainContract.Presenter {
    private val model: MainModel by lazy { MainModel() }

    override fun text() {
        view.setText(model.getText())
    }

}