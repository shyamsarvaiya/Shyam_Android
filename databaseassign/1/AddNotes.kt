package com.example.stickynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stickynotes.databinding.ActivityAddNotesBinding

class AddNotes : AppCompatActivity() {

    lateinit var Binding:ActivityAddNotesBinding
    lateinit var db:NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(Binding.root)
        db = NoteDatabaseHelper(this)

        //insert data for the textview
        Binding.save.setOnClickListener {
            val title= Binding.edit1.text.toString()
            val content = Binding.edit2.text.toString()
            val note =Note(0,title,content)
            db.insertNotes(note)
            finish()
            Toast.makeText(this,"Note Added Successfully",Toast.LENGTH_SHORT).show()
        }


    }
}