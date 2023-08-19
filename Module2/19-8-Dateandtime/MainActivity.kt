package com.example.dateandtimepickerex

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1.setOnClickListener {

            var d1 = DateEx()
            d1.show(supportFragmentManager,"")

        }
        btn2.setOnClickListener {

            var d1 = TimeEx()
            d1.show(supportFragmentManager,"")
        }

    }
}

class DateEx :DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var calender = Calendar.getInstance()
        var date = calender.get(Calendar.DAY_OF_MONTH)
        var month = calender.get(Calendar.MONTH)
        var year = calender.get(Calendar.YEAR)

        return DatePickerDialog(requireActivity(),this,year,month,date)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int)
    {
        Toast.makeText(requireActivity(),""+dayOfMonth+"-"+month+"-"+year,Toast.LENGTH_LONG).show()
    }
}

class TimeEx :DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var calender = Calendar.getInstance()
        var hour = calender.get(Calendar.HOUR_OF_DAY)
        var minute = calender.get(Calendar.MINUTE)


        return TimePickerDialog(requireActivity(),this,hour,minute,false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(requireActivity(),""+hourOfDay+"-"+minute,Toast.LENGTH_LONG).show()
    }


}