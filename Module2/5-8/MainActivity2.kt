package com.example.permissionex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity2 : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById(R.id.list)
        list = ArrayList()

        //set the data
        list.add(Model(R.drawable.a,"Person 1","Project Manager"))
        list.add(Model(R.drawable.b,"Person 2","Project Leader"))
        list.add(Model(R.drawable.c,"Person 3","Developer"))
        list.add(Model(R.drawable.d,"Person 4","Tester"))
        list.add(Model(R.drawable.a,"Person 1","Project Manager"))
        list.add(Model(R.drawable.b,"Person 2","Project Leader"))
        list.add(Model(R.drawable.c,"Person 3","Developer"))
        list.add(Model(R.drawable.d,"Person 4","Tester"))
        list.add(Model(R.drawable.a,"Person 1","Project Manager"))
        list.add(Model(R.drawable.b,"Person 2","Project Leader"))
        list.add(Model(R.drawable.c,"Person 3","Developer"))
        list.add(Model(R.drawable.d,"Person 4","Tester"))
        list.add(Model(R.drawable.a,"Person 1","Project Manager"))
        list.add(Model(R.drawable.b,"Person 2","Project Leader"))
        list.add(Model(R.drawable.c,"Person 3","Developer"))
        list.add(Model(R.drawable.d,"Person 4","Tester"))


        var myAdapter = MyAdapter(applicationContext,list)
        listView.adapter=myAdapter

    }
}