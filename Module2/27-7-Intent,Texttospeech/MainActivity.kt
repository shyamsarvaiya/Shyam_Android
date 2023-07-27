package com.example.myapplication2

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    //declare
    lateinit var img:ImageView
    lateinit var btn:Button
    lateinit var btn2:Button
    lateinit var txt1:TextView
    lateinit var tts:TextToSpeech

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize

        img = findViewById(R.id.img)
        btn = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)
        tts = TextToSpeech(applicationContext,this)
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(CAMERA)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE, CAMERA),101)
        }


        img.setOnClickListener {

            //Explicit Intent
            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)

        }
        btn.setOnClickListener {

            var url="https://www.tops-int.com"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }
        btn2.setOnClickListener {

            var num="9275003605"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }
        txt1.setOnClickListener {

            var data = txt1.text.toString()
            tts.speak(data,QUEUE_ADD,null)

        }


    }

    override fun onInit(status: Int)
    {
        tts.setLanguage(Locale.UK)
        tts.setPitch(0.9F)
        tts.setSpeechRate(0.9F)
    }
}