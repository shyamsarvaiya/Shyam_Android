package com.example.drawerex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        btn1.setOnClickListener {

        }
      /*
        btn1.setOnClickListener {

        }
        */

       /* btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)

        btn1.setOnClickListener {xyz()}*/
    }

    /*private fun xyz() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {

        if(v==btn1)
        {

        }
        if(v==btn2)
        {

        }
    }*/

     fun tops(v: View?)
     {
        if(v==btn1)
        {
            //Toast.makeText(applicationContext,"a",Toast.LENGTH_LONG).show()
            Snackbar.make(v,"success",Snackbar.LENGTH_LONG).show()
        }
    }
}