package com.example.kon.classes

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import com.example.kon.classes.R.id.*
import kotlinx.android.synthetic.main.a_circle.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when(position) {
                    0 -> {
                        //fragmentTriangle.layoutInflater.inflate(R.layout.a_circle, FrameLayout(baseContext))
                        val fr = ATriangle()
                        val args = Bundle()
                        args.putInt(ATriangle.TYPE_NAME, ATriangle.TYPE_CIRCLE)
                        fr.arguments = args
                        //supportFragmentManager.beginTransaction().replace(R.id.shapeGroup, fr).addToBackStack(null).commit()
                        supportFragmentManager.beginTransaction().replace(R.id.shapeGroup, fr).commit()
                        currentType = 0
                    }
                    1 -> {

                        val fr = ATriangle()
                        val args = Bundle()
                        args.putInt(ATriangle.TYPE_NAME, ATriangle.TYPE_TRIANGLE)
                        fr.arguments = args
                        supportFragmentManager.beginTransaction().replace(R.id.shapeGroup, fr).commit()
                        currentType = 1

                    }
                    2 -> {

                        val fr = ATriangle()
                        val args = Bundle()
                        args.putInt(ATriangle.TYPE_NAME, ATriangle.TYPE_SQUARE)
                        fr.arguments = args
                        supportFragmentManager.beginTransaction().replace(R.id.shapeGroup, fr).commit()
                        currentType = 2
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(baseContext, calcS().toString(), Toast.LENGTH_LONG).show()
            }
        })
        button2.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(baseContext, calcP().toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    fun calcS(): Double {
        var result: Double = 0.0
        when(currentType) {
            ATriangle.TYPE_CIRCLE -> result = Circle(ATriangle.currentView.findViewById<EditText>(R.id.editText2).text.toString().toInt()).s()
            ATriangle.TYPE_TRIANGLE -> result = Triangle(ATriangle.currentView.findViewById<EditText>(R.id.editText5).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText6).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText7).text.toString().toInt()).s()
            ATriangle.TYPE_SQUARE -> {
                if(ATriangle.currentView.findViewById<EditText>(R.id.editText).text.toString().length > 0 && ATriangle.currentView.findViewById<EditText>(R.id.editText3).text.toString().length > 0) {
                    result = Square(a = ATriangle.currentView.findViewById<EditText>(R.id.editText).text.toString().toInt(), b = ATriangle.currentView.findViewById<EditText>(R.id.editText3).text.toString().toInt()).s()
                } else {
                    result = Square(ATriangle.currentView.findViewById<EditText>(R.id.editText4).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText8).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText9).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText10).text.toString().toInt()).s()
                }
            }

        }
        return result
    }

    fun calcP(): Double {
        var result: Double = 0.0
        when(currentType) {
            ATriangle.TYPE_CIRCLE -> result = Circle(ATriangle.currentView.findViewById<EditText>(R.id.editText2).text.toString().toInt()).p()
            ATriangle.TYPE_TRIANGLE -> result = Triangle(ATriangle.currentView.findViewById<EditText>(R.id.editText5).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText6).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText7).text.toString().toInt()).p()
            ATriangle.TYPE_SQUARE -> {
                if(ATriangle.currentView.findViewById<EditText>(R.id.editText).text.toString().length > 0 && ATriangle.currentView.findViewById<EditText>(R.id.editText3).text.toString().length > 0) {
                    result = Square(a = ATriangle.currentView.findViewById<EditText>(R.id.editText).text.toString().toInt(), b = ATriangle.currentView.findViewById<EditText>(R.id.editText3).text.toString().toInt()).p()
                } else {
                    result = Square(ATriangle.currentView.findViewById<EditText>(R.id.editText4).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText8).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText9).text.toString().toInt(), ATriangle.currentView.findViewById<EditText>(R.id.editText10).text.toString().toInt()).p()
                }
            }

        }
        return result
    }


}
