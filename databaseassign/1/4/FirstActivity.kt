package com.example.todoapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.DTO.ToDo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class FirstActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var dbHandler: DBHandler
    lateinit var addFAB: FloatingActionButton
  // lateinit var relativeLayout:RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        setSupportActionBar(findViewById(R.id.toolbar))
     //   relativeLayout=findViewById(R.id.relative)
        title= "HOME"
        recyclerView = findViewById(R.id.first_recycle)
        addFAB = findViewById(R.id.fabbutton)
        dbHandler = DBHandler(this)
        recyclerView.layoutManager=LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        addFAB.setOnClickListener {

            val dialog =AlertDialog.Builder(this)
            dialog.setTitle("Add ToDo")
            val view =layoutInflater.inflate(R.layout.dialog_dashboard,null)
            val toDoName = view.findViewById<EditText>(R.id.tv_todo)
            dialog.setView(view)
            dialog.setPositiveButton("Add") { _: DialogInterface, i: Int ->
                if (toDoName.text.isNotEmpty()) {
                    val toDo = ToDo()
                    toDo.name = toDoName.text.toString()
                    /*val snackbar=Snackbar.make(relativeLayout,"Add Success",Snackbar.LENGTH_LONG)
                    snackbar.show()*/
                    dbHandler.addToDo(toDo)
                    refreshList()

                }
            }
            dialog.setNegativeButton("Cancel"){ _: DialogInterface, i: Int ->
            }
            dialog.show()
        }
    }
    // update task code
    fun updateTODO(toDo: ToDo)
    {
        val dialog =AlertDialog.Builder(this)
        dialog.setTitle("Update ToDo")
        val view =layoutInflater.inflate(R.layout.dialog_dashboard,null)
        val toDoName = view.findViewById<EditText>(R.id.tv_todo)
        toDoName.setText(toDo.name)
        dialog.setView(view)
        dialog.setPositiveButton("Update") { _: DialogInterface, i: Int ->
            if (toDoName.text.isNotEmpty()) {

                toDo.name = toDoName.text.toString()
                dbHandler.updateTodo(toDo)
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
        recyclerView.adapter = MyAdapter(this,dbHandler.getToDos())
    }



    class MyAdapter(val activity: FirstActivity, val list: MutableList<ToDo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>()
    {
        class ViewHolder(v:View):RecyclerView.ViewHolder(v)
        {
            val toDoName:TextView = v.findViewById(R.id.tv_todo_name)
            val menu:ImageView = v.findViewById(R.id.iv_menu)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

         return ViewHolder(LayoutInflater.from(activity).inflate(R.layout.rv_view,parent,false))

        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           holder.toDoName.text = list[position].name
           holder.toDoName.setOnClickListener {
               val intent = Intent(activity,Item_Activity::class.java)
               intent.putExtra(INTENT_TODO_ID,list[position].id)
               intent.putExtra(INTENT_TODO_NAME,list[position].name)
               activity.startActivity(intent)
           }
           holder.menu.setOnClickListener {
               val popup = PopupMenu(activity,holder.menu)
               popup.inflate(R.menu.home_page)
               popup.setOnMenuItemClickListener {
                   when(it.itemId){
                       R.id.upcoming->{
                           //pending task in the item task
                           val intent = Intent(activity,Item_Activity::class.java)
                           intent.putExtra(INTENT_TODO_ID,list[position].id)
                           intent.putExtra(INTENT_TODO_NAME,list[position].name)
                           activity.startActivity(intent)
                           activity.dbHandler.upcomingTodo(list[position].id)
                         //  activity.dbHandler.completeToDo(list[position].id,false)
                       }
                       R.id.complete->{
                            activity.dbHandler.completeToDo(list[position].id,true)
                       }
                       R.id.update->{
                           activity.updateTODO(list[position])

                       }
                       R.id.delete->{
                           val dialog=AlertDialog.Builder(activity)
                           dialog.setTitle("Are You Sure You Want to Delete ?")
                           dialog.setPositiveButton("Delete") { _: DialogInterface, _: Int ->
                               activity.dbHandler.deleteToDo(list[position].id)
                               activity.refreshList()
                           }
                           dialog.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
                           }
                           dialog.show()
                       }
                   }
                   true
               }
               popup.show()
           }

        }
    }
}