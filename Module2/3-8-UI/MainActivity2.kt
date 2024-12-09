package com.example.data3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class MainActivity2 : AppCompatActivity()
{
    lateinit var auto1:AutoCompleteTextView
    var city = arrayOf("rajkot","surat","baroda")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auto1 = findViewById(R.id.a1)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.select_dialog_item,city)
        auto1.threshold=1
        auto1.setAdapter(adapter)
    }
}