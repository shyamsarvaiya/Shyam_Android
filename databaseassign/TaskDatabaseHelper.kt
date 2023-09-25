package com.example.taskmanager

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.Collections

class TaskDatabaseHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){

    companion object{

        private const val DATABASE_NAME="Task.db"
        private const val DATABASE_VERSION=2
        private const val TABLE_NAME="task1"
        private const val COLUMN_ID="id"
        private const val COLUMN_TITLE="title"
        private const val COLUMN_CONTENT="content"
        private const val COLUMN_DATE="date"
        private const val COLUMN_TIME="time"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery="CREATE TABLE $TABLE_NAME($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_TITLE VARCHAR,$COLUMN_CONTENT VARCHAR,$COLUMN_DATE VARCHAR,$COLUMN_TIME VARCHAR)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery="DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    // insert task
    fun insertTask(task: Task)
    {
        val db= writableDatabase
        val values= ContentValues().apply {
            put(COLUMN_TITLE,task.title)
            put(COLUMN_CONTENT,task.content)
            put(COLUMN_DATE,task.date)
            put(COLUMN_TIME,task.time)
        }

        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    //view task

    fun getAlltask():List<Task>
    {
        val tasklist = mutableListOf<Task>()
        val db= readableDatabase
        val query= "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query,null)
        while (cursor.moveToNext())
        {
            val id= cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))
            val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))
            val time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME))




            val note=Task(id,title,content,date,time)
            tasklist.add(note)
        }
        cursor.close()
        db.close()
        return tasklist
    }
    // update task

    fun updatetask(task:Task)
    {
        val db= writableDatabase
        val values= ContentValues().apply {
            put(COLUMN_TITLE,task.title)
            put(COLUMN_CONTENT,task.content)
            put(COLUMN_DATE,task.date)
            put(COLUMN_TIME,task.time)
        }
        val whereClause = "$COLUMN_ID =?"
        val whereArgs = arrayOf(task.id.toString())
        db.update(TABLE_NAME,values,whereClause,whereArgs)
        db.close()
    }
    fun getTaskId(taskId:Int):Task
    {
        val db= readableDatabase
        val query= "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $taskId"
        val cursor = db.rawQuery(query,null)
        cursor.moveToNext()

        val id= cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
        val content= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))
        val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))
        val time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME))

        cursor.close()
        db.close()
        return Task(id,title,content,date,time)
    }


    // delete task

    fun deletetask(taskId: Int)
    {
        val db = writableDatabase
        val whereClause ="$COLUMN_ID =?"
        val whereargs  = arrayOf(taskId.toString())
        db.delete(TABLE_NAME,whereClause,whereargs)
        db.close()
    }

    // create method for the data view in listview
   /* fun viewData():Cursor
    {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        return db.rawQuery(query, null)
    }
*/

   /* fun getAllTask():List<Task>
    {
        val tasklist = mutableListOf<Task>()
        val db= readableDatabase
        val query= "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query,null)
        while (cursor.moveToNext())
        {
            val id= cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val content= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val task=Task(id,title,content)
            tasklist.add(task)
        }
        cursor.close()
        db.close()
        return tasklist
    }*/

}