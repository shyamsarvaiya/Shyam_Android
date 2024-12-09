package com.example.uicontrols

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.uicontrols.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)

        }
        binding.btn2.setOnClickListener {

            var a1 = BlankFragment()
            var fm:FragmentManager = supportFragmentManager
            var ft:FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.frmid,a1).commit()


        }
        binding.btn3.setOnClickListener {



        }
        binding.btn4.setOnClickListener {

        }
    }
}