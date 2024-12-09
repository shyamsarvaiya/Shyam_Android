package com.example.layoutsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.relative)

        linearLayout = LinearLayout(this)

        var textview = TextView(this)
        textview.setText("Tops")

        var width=500
        var height=500

        linearLayout.addView(textview,width,height)

        setContentView(linearLayout)
    }
}