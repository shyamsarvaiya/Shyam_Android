package com.example.sharedprefrenceex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity5 : AppCompatActivity()
{

     lateinit var mutableList: MutableList<Model>
     lateinit var listView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var i = intent
        var a = i.getStringExtra("e1")
       var b = i.getStringExtra("p1")

        var name:String = a.toString()
        var pass:String = b.toString()
        listView = findViewById(R.id.list)
        mutableList = ArrayList<Model>()

        mutableList.add(Model(name,pass))

        var myAdapter = MyAdapter(applicationContext,mutableList)
        listView.adapter=myAdapter



    }
}