package com.example.tablayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayoutex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.tool)

        binding.tab.setupWithViewPager(binding.viewpager)

        setupviewpager()

    }

    private fun setupviewpager()
    {
        var myAdapter = MyAdapter(supportFragmentManager)
        myAdapter.adddata(ChatFragment(),"CHAT")
        myAdapter.adddata(StatusFragment(),"STATUS")
        myAdapter.adddata(CallFragment(),"CALL")
        binding.viewpager.adapter=myAdapter

    }
}