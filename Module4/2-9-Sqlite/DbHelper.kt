package tops.tech.sqlitedbex1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="details"
        var ID="id"
        var NAME="name"
        var NUM="num"
        var DB_VERSION=1

    }


    override fun onCreate(db: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUM + " TEXT" + ")"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
       var upquery ="DROP TABLE IF EXISTS "+ TABLE_NAME
        db!!.execSQL(upquery)
        onCreate(db)
    }

    fun insertdata(m:Model) : Long
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)
        values.put(NUM,m.num)
        var id = db.insert(TABLE_NAME,ID,values)
        return id
    }

    fun viewdata():ArrayList<Model>
    {
        var list:ArrayList<Model> = ArrayList()
        var db = readableDatabase
        var data = arrayOf(ID, NAME, NUM)
        var cursor:Cursor = db.query(TABLE_NAME,data,null,null,null,null,null,null)
        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var num = cursor.getString(2)

            var m= Model()
            m.id = id
            m.name=name
            m.num=num

            list.add(m)
        }

        return  list
    }
}