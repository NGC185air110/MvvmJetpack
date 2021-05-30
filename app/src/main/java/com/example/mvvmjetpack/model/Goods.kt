package com.example.mvvmjetpack.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Goods : BaseObservable {
    @get:Bindable
    var name: String? = null
        set(name){
            field = name
            notifyPropertyChanged(com.example.mvvmjetpack.BR.name)
        }
    @get:Bindable
    var details: String? = null
        set(details){
            field = details
            notifyChange()
        }
    var price: Int? = null

    constructor(name: String?, details: String?, price: Int) : super() {
        this.name = name
        this.details = details
        this.price = price
    }

}