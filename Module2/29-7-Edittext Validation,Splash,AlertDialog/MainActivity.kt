package com.example.mydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            //Validations
            var name = edt1.text.toString()///get details from 1st edittext
            var pass = edt2.text.toString()//get details from 2nd edittext

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Please Enter Name")
                edt2.setError("Please Enter Password")
            }
            else if(name.length==0)
            {
                edt1.setError("Please Enter Name")
            }
            else if(pass.length==0)
            {
                edt2.setError("Please Enter Password")
            }
            else
            {
                if(name.equals("tops") && pass.equals("1234"))
                {
                    Toast.makeText(applicationContext, "Logged in succesfully", Toast.LENGTH_LONG).show()
                    var i = Intent(applicationContext,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext, "Logged in fail", Toast.LENGTH_LONG).show()

                }
            }



        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}