package com.example.drawerex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.AdapterView.AdapterContextMenuInfo

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener,
    AdapterView.OnItemLongClickListener {
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var btn1:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        btn1 = findViewById(R.id.btn1)



        btn1.setOnClickListener {

            var popup = PopupMenu(applicationContext,btn1)
            popup.menuInflater.inflate(R.menu.popup,popup.menu)
            popup.setOnMenuItemClickListener(this)
            popup.show()

        }


        list.add("Android")
        list.add("Java")
        list.add("Php")

        var arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=arrayAdapter
        //registerForContextMenu(listView)
        listView.setOnItemLongClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"Logout",Toast.LENGTH_LONG).show()
                Thread.sleep(2000)
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,""+acm.position,Toast.LENGTH_LONG).show()

                if(pos==0)
                {

                }
                if(pos==1)
                {

                }
                if(pos==2)
                {

                }


            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"clicked",Toast.LENGTH_LONG).show()
            }
        }
        return false
    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean
    {
        Toast.makeText(applicationContext,""+position,Toast.LENGTH_LONG).show()

        return false
    }


}