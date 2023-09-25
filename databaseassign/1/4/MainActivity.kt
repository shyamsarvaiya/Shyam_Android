package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
//Create an application of todo app using SQLite with function lite to create
//list of upcoming task, completed task, remove task, update task in daily
//activity.
class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.img1)

        //animation add in main activity

        imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_in))
        Handler().postDelayed({
            imageView.startAnimation(AnimationUtils.loadAnimation(this,R.anim.splash_out))
            Handler().postDelayed({
                imageView.visibility = View.GONE
                startActivity(Intent(this,FirstActivity::class.java))
                finish()
            },500)
        },2000)

    }
}