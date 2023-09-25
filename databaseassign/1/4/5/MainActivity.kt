package com.example.work_management

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.work_management.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2: Button
    lateinit var textView: TextView
    @SuppressLint("SuspiciousIndentation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.bt1)
        button2 = findViewById(R.id.bt2)
        textView = findViewById(R.id.text2)

            button.setOnClickListener {

            val intent = Intent(this,Signup::class.java)
            startActivity(intent)

        }
           button2.setOnClickListener {

            val intent= Intent(this,Login::class.java)
            startActivity(intent)

        }

    }
}
