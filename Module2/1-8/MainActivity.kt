package com.example.checkboxex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var builder = StringBuilder("\n Selected Items")
            var amount =0

            if(chk1.isChecked)
            {
                builder.append("\n Pizza - Rs. 100")
                amount+=100
            }
            if(chk2.isChecked)
            {
                builder.append("\n Burger - Rs. 70")
                amount+=70
            }
            if(chk3.isChecked)
            {
                builder.append("\n Coffee - Rs. 120")
                amount+=120
            }

            builder.append("\n Total :"+amount)

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("bill",builder.toString())
            startActivity(i)


        }

    }
}