package com.example.todoapp

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.DTO.ToDoItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Item_Activity : AppCompatActivity() {

    private lateinit var recyclerView2: RecyclerView
    private lateinit var dbHandler: DBHandler
    private lateinit var itemfab : FloatingActionButton
    private var todoId:Long=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        itemfab = findViewById(R.id.itemfabbutton)
        recyclerView2 = findViewById(R.id.item_recycle)
        dbHandler = DBHandler(this)
        todoId=intent.getLongExtra(INTENT_TODO_ID,-1)
        setSupportActionBar(findViewById(R.id.item_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = intent.getStringExtra(INTENT_TODO_NAME)

        recyclerView2.layoutManager=LinearLayoutManager(this)
        itemfab.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Add ToDo Item")
            val view =layoutInflater.inflate(R.layout.dialog_dashboard,null)
            val toDoName = view.findViewById<EditText>(R.id.tv_todo)
            dialog.setView(view)
            dialog.setPositiveButton("Add") { _: DialogInterface, i: Int ->
                if (toDoName.text.isNotEmpty()) {
                    val item=ToDoItem()
                    item.itemName=toDoName.text.toString()
                    item.toDoId= todoId
                    item.isCompleted= false
                    dbHandler.addToDoItem(item)
                    refreshList()
                }
            }
            dialog.setNegativeButton("Cancel"){ _: DialogInterface, i: Int ->



            }
            dialog.show()
        }
    }
    //update to sub task

    fun updateItem(item:ToDoItem)
    {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Update ToDo Item")
        val view =layoutInflater.inflate(R.layout.dialog_dashboard,null)
        val toDoName = view.findViewById<EditText>(R.id.tv_todo)
        dialog.setView(view)
        toDoName.setText(item.itemName)
        dialog.setPositiveButton("Update") { _: DialogInterface, i: Int ->
            if (toDoName.text.isNotEmpty()) {
                item.itemName=toDoName.text.toString()
                item.toDoId= todoId
                item.isCompleted= false
                dbHandler.updateToDoItem(item)
                refreshList()
            }
        }
        dialog.setNegativeButton("Cancel"){ _: DialogInterface, i: Int ->



        }
        dialog.show()
    }

    override fun onResume() {
        refreshList()
        super.onResume()
    }
    private fun refreshList()
    {
        recyclerView2.adapter=ItemMyAdapter(this,dbHandler.getToDoItems(todoId))
    }
    //task inside task code
    class ItemMyAdapter( val activity: Item_Activity, private val list: MutableList<ToDoItem>)
        : RecyclerView.Adapter<ItemMyAdapter.ViewHolder>()
    {
        class ViewHolder(v: View):RecyclerView.ViewHolder(v)
        {
            val itemName: CheckBox = v.findViewById(R.id.check_item1)
            val edit:ImageView=v.findViewById(R.id.iv_edit)
            val delete:ImageView=v.findViewById(R.id.iv_delete)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            return ViewHolder(LayoutInflater.from(activity).inflate(R.layout.rv_item,parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemName.text = list[position].itemName
            holder.itemName.isChecked=list[position].isCompleted
            holder.itemName.setOnClickListener {
                list[position].isCompleted=!list[position].isCompleted
                activity.dbHandler.updateToDoItem(list[position])

            }
            holder.delete.setOnClickListener {
                val dialog=AlertDialog.Builder(activity)
                dialog.setTitle("Are You Sure You Want to Delete Task ?")
                dialog.setPositiveButton("Delete") { _: DialogInterface, _: Int ->
                    activity.dbHandler.deleteToDoItem(list[position].id)
                    activity.refreshList()
                }
                dialog.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
                }
                dialog.show()

            }
            holder.edit.setOnClickListener {
                activity.updateItem(list[position])
            }
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if(item.itemId == android.R.id.home)
        {
            finish()
            true
        }else
        super.onOptionsItemSelected(item)
    }
}
