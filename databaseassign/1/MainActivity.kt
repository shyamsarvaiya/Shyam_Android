package com.example.stickynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickynotes.databinding.ActivityMainBinding

/*Create a Sticky Notes app with proper customization which can
insert,view,update,delete using SQLite database*/


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbhelper:NoteDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbhelper = NoteDatabaseHelper(this)
        notesAdapter = NotesAdapter(dbhelper.getAllnotes(),this)

        binding.recycleviewnote.layoutManager =LinearLayoutManager(this)
        binding.recycleviewnote.adapter = notesAdapter

        binding.addbutton.setOnClickListener {
            val intent =Intent(MainActivity@this,AddNotes::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshdata(dbhelper.getAllnotes())
    }
}