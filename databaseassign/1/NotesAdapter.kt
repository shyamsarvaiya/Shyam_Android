package com.example.stickynotes

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter (private var notes:List<Note>, val context: Context):
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
private val db:NoteDatabaseHelper = NoteDatabaseHelper(context)
    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val titletextview:TextView = itemView.findViewById(R.id.titletextview)
        val contenttextview:TextView = itemView.findViewById(R.id.contenttextview)
        //update details
        val updateButton:ImageView = itemView.findViewById(R.id.update)
        //delete details
        val deleteButton:ImageView = itemView.findViewById(R.id.delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)

        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {


        val note=notes[position]
        holder.titletextview.text =note.title
        holder.contenttextview.text =note.content
        //update details
        holder.updateButton.setOnClickListener {
            val intent =Intent(holder.itemView.context,UpdateActivity::class.java).apply {
                putExtra("note_id",note.id)
            }
            holder.itemView.context.startActivity(intent)
        }
        //delete details
        holder.deleteButton.setOnClickListener {
           db.deletenote(note.id)
            refreshdata(db.getAllnotes())
            Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show()
        }

    }
    fun refreshdata(newNotes: List<Note>)
    {
        notes = newNotes
        notifyDataSetChanged()
    }


}