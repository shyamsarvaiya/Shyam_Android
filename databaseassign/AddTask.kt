package com.example.taskmanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.taskmanager.databinding.ActivityAddTaskBinding
import java.util.Calendar

class AddTask : AppCompatActivity() {

   /* lateinit var Binding:ActivityAddTaskBinding
    lateinit var db:TaskDatabaseHelper*/

    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    private lateinit var date:EditText
    private lateinit var time:EditText

    private lateinit var save:ImageView
    private lateinit var db:TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        editText = findViewById(R.id.title)
        editText2 = findViewById(R.id.description)
        date = findViewById(R.id.date)
        time = findViewById(R.id.time)
        save = findViewById(R.id.save)

        db = TaskDatabaseHelper(this)

        //date picker add
        date.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
              date.setText(dat)
            },year,month,day)
            datePickerDialog.show()


        }
        // time picker add

        time.setOnClickListener {

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
                    if (time != null) {
                        val hour = if (hour < 10) "$selectedHour" else hour
                        val min = if (selectedMinute < 10) "$selectedMinute" else minute
                        val dat = "$hour : $min $am_pm"
                        time.setText(dat)
                    }

                },hour, minute, false)

                timePickerDialog.show()

        }


        save.setOnClickListener {

            val title= editText.text.toString()
            val content =editText2.text.toString()
            val date = date.text.toString()
            val time = time.text.toString()
            val task =Task(0,title,content,date,time)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Added Successfully",Toast.LENGTH_SHORT).show()

        }




      /*  Binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        db = TaskDatabaseHelper(this)

        //insert task
        Binding.save.setOnClickListener {
            val title= Binding.title.text.toString()
            val content = Binding.description.text.toString()
            val task =Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Added Successfully", Toast.LENGTH_SHORT).show()
        }

*/
    }
}