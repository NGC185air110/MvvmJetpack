package com.example.mvvmjetpack

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class BlankFragment(var a: String) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var inflaters = inflater.inflate(R.layout.fragment_blank, container, false)
        var tv_text: TextView = inflaters.findViewById(R.id.tv_text)
        tv_text.text = a
        return inflaters
    }

}