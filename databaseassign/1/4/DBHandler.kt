package com.example.todoapp


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.todoapp.DTO.ToDo
import com.example.todoapp.DTO.ToDoItem

class DBHandler(private val context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        val createToDoTable="CREATE TABLE $TABLE_TODO(" +
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT," +
                "$COL_CREATED_AT datetime  DEFAULT CURRENT_TIMESTAMP," +
                "$COL_NAME varchar);"

        val createToDoItemTable=
            "CREATE TABLE $TABLE_TODO_ITEM(" +
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT," +
                "$COL_CREATED_AT datetime  DEFAULT CURRENT_TIMESTAMP," +
                "$COL_TODO_ID integer," +
                "$COL_ITEM_NAME varchar," +
                "$COL_IS_COLPLETED integer);"


        db.execSQL(createToDoTable)
        db.execSQL(createToDoItemTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addToDo(toDo:ToDo): Boolean {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME,toDo.name)
        val result=db.insert(TABLE_TODO,null,cv)
        return result != (-1).toLong()
    }
    //update code
    fun updateTodo(toDo: ToDo){
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME,toDo.name)
        db.update(TABLE_TODO,cv,"$COL_ID=?", arrayOf(toDo.id.toString()))
    }
    @SuppressLint("Range")
    fun getToDos():MutableList<ToDo>
    {
        val result:MutableList<ToDo> = ArrayList()
        val db=readableDatabase
        val queryResult =db.rawQuery("SELECT * FROM $TABLE_TODO",null)
        if(queryResult.moveToFirst())
        {
            do{
                val todo= ToDo()
                todo.id = queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                todo.name = queryResult.getString(queryResult.getColumnIndex(COL_NAME))
                result.add(todo)
            }while (queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }
    //completed code task
    @SuppressLint("Range")
    fun completeToDo(todoId: Long, isCompleted: Boolean)
    {
        val db=writableDatabase
        val queryResult=db.rawQuery("SELECT * FROM $TABLE_TODO_ITEM WHERE $COL_TODO_ID=$todoId",null)
        if(queryResult.moveToFirst()){
            do{
                val item=ToDoItem()
                item.id=queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                item.toDoId=queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID))
                item.itemName=queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME))
                item.isCompleted= isCompleted
                //  item.toDoId=todoId
                updateToDoItem(item)

            }while (queryResult.moveToNext())
        }
        queryResult.close()
    }
    //upcoming code task

    @SuppressLint("Range")
    fun upcomingTodo(todoId: Long):MutableList<ToDoItem>
    {
        val db=writableDatabase
        val result:MutableList<ToDoItem> = ArrayList()
        val queryResult=db.rawQuery("SELECT * FROM $TABLE_TODO_ITEM WHERE $COL_TODO_ID=$todoId",null)
        if(queryResult.moveToFirst())
        {
            do{
                val item=ToDoItem()
                item.id=queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                item.toDoId=queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID))
                item.itemName=queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME))
                item.isCompleted=queryResult.getInt(queryResult.getColumnIndex(COL_IS_COLPLETED)) == 1
                result.add(item)

            }while (queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }

    //delete code of the subtask
    fun deleteToDoItem(itemId:Long)
    {
        val db=writableDatabase
        db.delete(TABLE_TODO_ITEM,"$COL_ID=?", arrayOf(itemId.toString()))
    }

    //delete task code
    fun deleteToDo(todoId: Long){
        val db=writableDatabase
        db.delete(TABLE_TODO_ITEM,"$COL_TODO_ID=?", arrayOf(todoId.toString()))
        db.delete(TABLE_TODO,"$COL_ID=?", arrayOf(todoId.toString()))
    }

    //task inside task code
    fun addToDoItem(item:ToDoItem):Boolean
    {
        val db = writableDatabase
        val cv =ContentValues()
        cv.put(COL_ITEM_NAME,item.itemName)
        cv.put(COL_TODO_ID,item.toDoId)
        if(item.isCompleted)
            cv.put(COL_IS_COLPLETED,true)
        else
            cv.put(COL_IS_COLPLETED,false)
        val result= db.insert(TABLE_TODO_ITEM,null,cv)
        return result!=(-1).toLong()

    }
    fun updateToDoItem(item:ToDoItem)
    {
        val db = writableDatabase
        val cv =ContentValues()
        cv.put(COL_ITEM_NAME,item.itemName)
        cv.put(COL_TODO_ID,item.toDoId)
        cv.put(COL_IS_COLPLETED,item.isCompleted)
       /* if(item.isCompleted)
            cv.put(COL_IS_COLPLETED,true)
        else
            cv.put(COL_IS_COLPLETED,false)*/
        db.update(TABLE_TODO_ITEM,cv,"$COL_ID=?", arrayOf(item.id.toString()))

    }

    @SuppressLint("Range")
    fun getToDoItems(todoId:Long):MutableList<ToDoItem>
    {
        val result:MutableList<ToDoItem> = ArrayList()
        val db=readableDatabase
        val queryResult=db.rawQuery("SELECT * FROM $TABLE_TODO_ITEM WHERE $COL_TODO_ID=$todoId",null)
        if(queryResult.moveToFirst()){
            do{
                val item=ToDoItem()
                item.id=queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                item.toDoId=queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID))
                item.itemName=queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME))
                item.isCompleted=queryResult.getInt(queryResult.getColumnIndex(COL_IS_COLPLETED)) == 1
              //  item.toDoId=todoId
                result.add(item)

            }while (queryResult.moveToNext())
        }

        queryResult.close()
        return result
    }
}