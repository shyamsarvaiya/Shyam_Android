package com.example.taskmanager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Collections

class MainActivity : AppCompatActivity()
{

   // private lateinit var binding: ActivityMainBinding
   private lateinit var dbhelper:TaskDatabaseHelper
   private lateinit var  add:FloatingActionButton
   private lateinit var userlist: ListView
   private lateinit var taskAdapter: TaskAdapter
   private lateinit var listItem :ArrayList<Task>
  // private lateinit var listItem: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.addbutton)
        userlist = findViewById(R.id.listview)
        dbhelper = TaskDatabaseHelper(this)
        listItem = ArrayList()


      /*
        listItem = ArrayList()*/
        //viewData()

        //adapter = ArrayAdapter(this,android.R.layout.simple_list_item1,listItem)
    //design file add in the list

      /*  adapter = TaskAdapter(this@MainActivity,listItem)
        userlist.adapter = adapter
*/

        add.setOnClickListener {
            val intent = Intent(MainActivity@this,AddTask::class.java)
            startActivity(intent)
        }

        taskAdapter = TaskAdapter(this, listItem)
        userlist.adapter = taskAdapter


/*
        val arrayList: ArrayList<String> = helper.getAllTask() as ArrayList<String>


        val listView: ListView = findViewById(R.id.listview)
        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(this@MainActivity,
            android.R.layout.simple_list_item_1, arrayList as List<Any?>)
        listView.adapter = arrayAdapter*/
    }
    override fun onResume() {
        super.onResume()
        taskAdapter.refreshdata(dbhelper.getAlltask())
    }
   /* private fun viewData() {
        val cursor: Cursor = dbhelper.viewData()

        if (cursor.count == 0) {
            Toast.makeText(this, "No DATA to show", Toast.LENGTH_SHORT).show()
        } else {
            while (cursor.moveToNext()) {
                listItem.add(cursor.getString(1))
            }
            adapter = ArrayAdapter(this, R.layout.design, listItem)
            userlist.adapter = adapter
        }
    }*/
    //option menu code
    // first adapter display here
    
}