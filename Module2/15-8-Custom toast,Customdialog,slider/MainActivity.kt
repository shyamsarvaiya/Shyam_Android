package com.example.data2

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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

            //custom toast
            var toast = Toast(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design_toast,null)
            toast.view=view
            toast.duration=Toast.LENGTH_LONG
            toast.show()


        }
        btn2.setOnClickListener {


            var alertDialog = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design_toast,null)
            alertDialog.setView(view)
            alertDialog.setNeutralButton("OK",{ dialogInterface: DialogInterface, i: Int ->

                Toast.makeText(applicationContext,"OK",Toast.LENGTH_LONG).show()

            })
            alertDialog.show()

        }

    }
}