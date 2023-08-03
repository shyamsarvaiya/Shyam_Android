package com.example.data3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var searchview:SearchView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        searchview = findViewById(R.id.search)

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Flutter")


        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

        searchview.setOnQueryTextListener(object :SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {

                    if(list.contains(query))
                    {
                        adapter.filter.filter(query)
                    }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                adapter.filter.filter(newText)

                return false
            }
        })


    }
}