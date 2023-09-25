package com.example.work_management

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var login: Button

    lateinit var dbh: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)

        login = findViewById(R.id.login)


        dbh = DatabaseHelper(this)


        login.setOnClickListener {

            val uname=edit1.text.toString()
            val pass= edit2.text.toString()
            if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass))
            {
                Toast.makeText(this,"add user and password",Toast.LENGTH_LONG).show()
            }
            else
            {
                val checkuser = dbh.checkuserpass(uname,pass)

                if(checkuser == true)
                {
                    Toast.makeText(this,"Logged in",Toast.LENGTH_LONG).show()
                    val intent=Intent(applicationContext, MainActivity2::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show()
                }
            }


        }

        /* login.setOnClickListener {

            val uname=edit1.text.toString()
            val pass= edit2.text.toString()

            if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass))
            {
                Toast.makeText(this,"add user and password",Toast.LENGTH_LONG).show()
            }
            else
            {
               // val checkuser = dbh.checkuserpass(uname,pass)

          *//*      if(checkuser == true)
                {
                    Toast.makeText(this,"Logged in",Toast.LENGTH_LONG).show()
                    val intent=Intent(this,Signup::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"wrong",Toast.LENGTH_LONG).show()
                }
            }*//*
        }
    }*/
    }
}