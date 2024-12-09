package com.example.data3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity3 : AppCompatActivity()
{
    lateinit var spinner: Spinner
    var city = arrayOf("rajkot","surat","baroda")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        spinner = findViewById(R.id.spin)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,city)
        spinner.adapter=adapter

        spinner.setOnItemSelectedListener(object :OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                Toast.makeText(applicationContext,""+city[position],Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        })



    }
}