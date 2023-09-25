package com.example.stickynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stickynotes.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    lateinit var Binding: ActivityUpdateBinding
    lateinit var db:NoteDatabaseHelper
    private var noteId:Int =-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        db = NoteDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id",-1)
        if(noteId == -1)
        {
            finish()
            return
        }
        val note = db.getNoteId(noteId)
        Binding.updateedit1.setText(note.title)
        Binding.updateedit2.setText(note.content)

        Binding.updatesave.setOnClickListener {

            val newtitle = Binding.updateedit1.text.toString()
            val newcontent = Binding.updateedit2.text.toString()
            val updatenote = Note(noteId,newtitle,newcontent)

            db.updatenote(updatenote)
            finish()
            Toast.makeText(this,"Update Success",Toast.LENGTH_SHORT).show()
        }
    }
}