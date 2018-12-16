package com.example.kon.classes

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ATriangle: Fragment() {
    companion object {
        val TYPE_NAME = "type"
        val TYPE_CIRCLE = 0
        val TYPE_TRIANGLE = 1
        val TYPE_SQUARE = 2

        lateinit var currentView: View
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val bundle: Bundle? = this.arguments
        Log.d("get from bundle", "v = " + bundle?.get(TYPE_NAME))
        val type: Int = (bundle?.getInt(TYPE_NAME) ?: 0)
        var result: View? = null
        when(type) {
            TYPE_CIRCLE -> result = inflater!!.inflate(R.layout.a_circle, container, false)
            TYPE_TRIANGLE -> result = inflater!!.inflate(R.layout.a_triangle, container, false)
            TYPE_SQUARE -> result = inflater!!.inflate(R.layout.a_square, container, false)
        }
        currentView = result!!
        return result!!
    }



}