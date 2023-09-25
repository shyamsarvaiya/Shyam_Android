package com.example.taskmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class TaskAdapter(var context: Context, private var task:List<Task>) : BaseAdapter()
{
 /*   private val context: Context
    private val task: ArrayList<Task>*/


    private val db:TaskDatabaseHelper = TaskDatabaseHelper(context)

    override fun getCount(): Int {
       return task.size
    }

    override fun getItem(position: Int): Any {
        return task[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.design, parent, false)
        }
        val currentItem = getItem(position) as Task
        val textViewItemName = convertView?.findViewById(R.id.titletextview) as TextView
        val textViewItemDescription = convertView?.findViewById(R.id.contenttextview) as TextView
        val textViewdate = convertView?.findViewById(R.id.showdate) as TextView
        val textViewtime = convertView?.findViewById(R.id.showtime) as TextView
        val taskmenu = convertView?.findViewById(R.id.iv_menu) as ImageView


        //for the option menu
        taskmenu.setOnClickListener {


            val popup = PopupMenu(context,taskmenu)
            popup.inflate(R.menu.home_page)

            popup.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.complete->
                    {
                        db.deletetask(currentItem.id)
                        refreshdata(db.getAlltask())
                        Toast.makeText(context,"Complete",Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
            popup.show()

        }


        //for the update task

        val updatebutton = convertView?.findViewById(R.id.update) as ImageView

        updatebutton.setOnClickListener {
            val intent = Intent(context,Update::class.java)
            intent.putExtra("task_id",currentItem.id)
            context.startActivity(intent)
        }
        // for the delete task
        val delete = convertView?.findViewById(R.id.delete) as ImageView

        delete.setOnClickListener {

                db.deletetask(currentItem.id)
                refreshdata(db.getAlltask())
                Toast.makeText(context,"Delete Successfully",Toast.LENGTH_SHORT).show()
        }


        /* val updatebutton = convertView?.findViewById(R.id.update) as ImageView
          updatebutton.setOnClickListener {

              val intent= Intent(context,Update::class.java).apply {
                  putExtra("task_id",task.id)
              }
                context.startActivity(intent)
        }*/

        textViewItemName.text = currentItem.title
        textViewItemDescription.text = currentItem.content
        textViewdate.text = currentItem.date
        textViewtime.text = currentItem.time

        return convertView

    }
    init {
        this.context = context
        this.task = task
    }

    fun refreshdata(newTask: List<Task>)
    {
        task = newTask
        notifyDataSetChanged()
    }
}