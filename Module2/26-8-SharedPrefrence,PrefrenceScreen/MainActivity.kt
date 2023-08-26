package com.example.sharedprefrenceex

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edtemail)
        edt2 = findViewById(R.id.edtpass)
        btn1 = findViewById(R.id.btnlogin)
        sharedPreferences = getSharedPreferences("SESSION",Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("SESSION",false) && !sharedPreferences.getString("EMAIL","")!!.isEmpty())
        {
                startActivity(Intent(applicationContext,MainActivity2::class.java))
                finish()
        }

        btn1.setOnClickListener {

            var email = edt1.text.toString()
            var pass = edt2.text.toString()

            var i = Intent(applicationContext,MainActivity2::class.java)
            var editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("SESSION",true)
            editor.putString("EMAIL",email)
            editor.putString("PASS",pass)
            editor.commit()
            startActivity(i)
        }
    }
}