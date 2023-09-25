package com.example.stickynotes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDatabaseHelper(context:Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object{

        private const val DATABASE_NAME="allnotes.db"
        private const val DATABASE_VERSION=2
        private const val TABLE_NAME="note"
        private const val COLUMN_ID="id"
        private const val COLUMN_TITLE="title"
        private const val COLUMN_CONTENT="content"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery="CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_TITLE VARCHAR,$COLUMN_CONTENT VARCHAR)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
       val dropTableQuery="DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }
    //insert function
    fun insertNotes(note: Note)
    {
        val db= writableDatabase
        val values= ContentValues().apply {
            put(COLUMN_TITLE,note.title)
            put(COLUMN_CONTENT,note.content)
        }
        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    //view function
    fun getAllnotes():List<Note>
    {
        val noteslist = mutableListOf<Note>()
        val db= readableDatabase
        val query= "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query,null)
        while (cursor.moveToNext())
        {
            val id= cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val note=Note(id,title,content)
            noteslist.add(note)
        }
        cursor.close()
        db.close()
        return noteslist
    }
    //update function

    fun updatenote(note:Note)
    {
        val db= writableDatabase
        val values= ContentValues().apply {
            put(COLUMN_TITLE,note.title)
            put(COLUMN_CONTENT,note.content)
        }
      val whereClause = "$COLUMN_ID =?"
        val whereArgs = arrayOf(note.id.toString())
        db.update(TABLE_NAME,values,whereClause,whereArgs)
        db.close()
    }
    // update get function
    fun getNoteId(noteId:Int):Note
    {
        val db= readableDatabase
        val query= "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $noteId"
        val cursor = db.rawQuery(query,null)
        cursor.moveToNext()

            val id= cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            cursor.close()
            db.close()
            return Note(id,title,content)
    }
    //delete function
    fun deletenote(noteId: Int)
    {
        val db = writableDatabase
        val whereClause ="$COLUMN_ID =?"
        val whereargs  = arrayOf(noteId.toString())
        db.delete(TABLE_NAME,whereClause,whereargs)
        db.close()
    }
}