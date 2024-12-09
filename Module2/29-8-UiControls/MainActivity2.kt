package com.example.switchex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.RadioButton
import android.widget.RatingBar
import android.widget.Switch
import android.widget.Toast

class MainActivity2 : AppCompatActivity()
{
    lateinit var s1: Switch
    lateinit var webview1: WebView
    lateinit var rating1:RatingBar
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        s1 = findViewById(R.id.s1)
        webview1 = findViewById(R.id.web)
        webview1.loadUrl("https://www.tops-int.com")
        rating1 = findViewById(R.id.rate1)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        s1.setOnCheckedChangeListener { buttonView, isChecked ->

            if(s1.isChecked)
            {
                Toast.makeText(applicationContext,"SWITCH IS ON", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"SWITCH IS OFF", Toast.LENGTH_LONG).show()
            }


        }
        rating1.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->


            Toast.makeText(applicationContext,""+ratingBar.rating,Toast.LENGTH_LONG).show()

        }
        rb1.setOnCheckedChangeListener { buttonView, isChecked ->

            if(rb1.isChecked)
            {
                Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
            }

        }
        rb2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(rb2.isChecked)
            {
                Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
            }


        }
    }
}