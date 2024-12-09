package com.example.sharedprefrenceex

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var txt1:TextView
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        btn1.setOnClickListener {

            var i = Intent(applicationContext,MainActivity4::class.java)
            startActivity(i)
        }
        btn2.setOnClickListener {

         var name:String = sharedPreferences.getString("edt1","Enter detail")!!
         var pass:String = sharedPreferences.getString("edt2","Enter detail")!!
         var lan:Boolean =   sharedPreferences.getBoolean("check1",false)
         var list:String = sharedPreferences.getString("list1","Enter detail")!!

            txt1.append(name)
            txt1.append(pass)
            txt1.append(lan.toString())
            txt1.append(list)

        }
    }
}