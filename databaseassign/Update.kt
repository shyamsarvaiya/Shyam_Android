package com.example.taskmanager

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.Calendar

class Update : AppCompatActivity() {

    lateinit var db:TaskDatabaseHelper
    lateinit var edit1:EditText
    lateinit var edit2:EditText
    lateinit var edit3:EditText
    lateinit var edit4:EditText

    lateinit var save2:ImageView
    private var taskId:Int =-1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        db = TaskDatabaseHelper(this)
        edit1= findViewById(R.id.title2)
        edit2 = findViewById(R.id.description2)
        save2 = findViewById(R.id.save2)
        edit3 = findViewById(R.id.date2)
        edit4 = findViewById(R.id.time2)

        //update date picker
        edit3.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                edit3.setText(dat)
            },year,month,day)
            datePickerDialog.show()

        }
        //update time picker
        edit4.setOnClickListener {
            val mcurrentTime: Calendar = Calendar.getInstance()
            val hour: Int = mcurrentTime.get(Calendar.HOUR_OF_DAY)
            val minute: Int = mcurrentTime.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this,
                { timePicker, selectedHour, selectedMinute ->
                    var hour = hour
                    var am_pm = ""
                    when {
                        hour == 0 -> {
                            hour += 12
                            am_pm = "AM"
                        }

                        hour == 12 -> am_pm = "PM"
                        hour > 12 -> {
                            hour -= 12
                            am_pm = "PM"
                        }

                        else -> am_pm = "AM"
                    }
                    if (edit4 != null) {
                        val hour = if (hour < 10) "$selectedHour" else hour
                        val min = if (selectedMinute < 10) "$selectedMinute" else minute
                        val dat = "Time is: $hour : $min $am_pm"
                            edit4.setText(dat)
                    }

                },hour, minute, false)

            timePickerDialog.show()

        }

        taskId = intent.getIntExtra("task_id",-1)
        if(taskId == -1)
        {
            finish()
            return
        }


        val task = db.getTaskId(taskId)
        edit1.setText(task.title)
        edit2.setText(task.content)
        edit3.setText(task.date)
        edit4.setText(task.time)
        save2.setOnClickListener {

            val newtitle = edit1.text.toString()
            val newcontent = edit2.text.toString()
            val newdate = edit3.text.toString()
            val newtime = edit4.text.toString()
            val updatetask = Task(taskId,newtitle,newcontent,newdate,newtime)
            db.updatetask(updatetask)
            finish()
            Toast.makeText(this,"Update Success", Toast.LENGTH_SHORT).show()
        }
    }
}