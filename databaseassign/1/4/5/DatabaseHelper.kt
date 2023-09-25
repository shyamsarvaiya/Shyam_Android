package com.example.work_management

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Bitmap
import android.widget.Toast
import java.io.ByteArrayOutputStream


class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "Userdata3", null, 2) {


    private lateinit var byteArrayOutputStream: ByteArrayOutputStream
    private var imageInBytes:Byte =0
    // create table sql query
  /*  private val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_CPASSWORD +"TEXT,"
            + COLUMN_USER_NO + "TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")")*/
    // drop table sql query


    /*private val DROP_USER_TABLE = "DROP TABLE IF EXISTS $3
    1USERDB"
*/
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table Userdata(username text primary key,password text,cpassword text,number text,email text,image blob)")
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //Drop User Table if exist
        db.execSQL("drop table if exists Userdata")
        // Create tables again
    }
    //(username:String,password: String,cpassword:String,number:String,email:String,image:blob): Boolean

    fun insertdata(modelClass: ModelClass):Boolean{


        val db= this.writableDatabase
        val imageToStoreBitmap: Bitmap = modelClass.getImage()

        val byteArrayOutputStream = ByteArrayOutputStream()

        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val imageInBytes = byteArrayOutputStream.toByteArray()

        val cv = ContentValues()
        cv.put("username",modelClass.getUserName())
        cv.put("Password",modelClass.getPassword())
        cv.put("cpassword",modelClass.getCpassword())
        cv.put("no",modelClass.getMobile())
        cv.put("email",modelClass.getEmail())
        cv.put("image",imageInBytes)

        var result: Long = db.insert("Userdata",null,cv)

        if(result ==-1 .toLong())
        {
            return true
        }
        return false

      /*  val cv = ContentValues()
        cv.put("username",username)
        cv.put("Password",password)
        cv.put("cpassword",cpassword)
        cv.put("no",number)
        cv.put("email",email)

        val result = db.insert("Userdata",null,cv)

        if(result ==-1 .toLong())
        {
            return true
        }
        return false*/
    }
    fun getUser(): Cursor
    {
        val db: SQLiteDatabase = this.readableDatabase
        val cursor: Cursor = db.rawQuery("Select * from UserData", null)
        return cursor
    }

    fun checkuserpass(username: String,password: String): Boolean {


        val db= this.writableDatabase

        val query ="select * from Userdata where username='$username' and password='$password'"

        val cursor =db.rawQuery(query,null)

        if(cursor.count<=0)
        {
            cursor.close()
            return true
        }
            cursor.close()
            return false
    }
}
    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    /*fun getAllUser(): List<UserData> {
        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID, COLUMN_USER_EMAIL, COLUMN_USER_NAME, COLUMN_USER_PASSWORD,COLUMN_USER_CPASSWORD,COLUMN_USER_NO)
        // sorting orders
        val sortOrder = "$COLUMN_USER_NAME ASC"
        val userList = ArrayList()
        val db = this.readableDatabase
        // query the user table
        val cursor = db.query(TABLE_USER, //Table to query
            columns,            //columns to return
            null,     //columns for the WHERE clause
            null,  //The values for the WHERE clause
            null,      //group the rows
            null,       //filter by row groups
            sortOrder)         //The sort order
        if (cursor.moveToFirst()) {
            do {
                val user = UserData(id = cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)).toInt(),
                    uname = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)),
                    email = cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)),
                    unumber = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NO)),
                    cpassword = cursor.getString(cursor.getColumnIndex(COLUMN_USER_CPASSWORD)),
                    password=cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)))
                userList.add(user)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return userList
    }
    *//**
     * This method is to create user record
     *
     * @param //user
     *//*
    fun addUser(user: UserData) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.uname)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)
        values.put(COLUMN_USER_NO,user.unumber)
        values.put(COLUMN_USER_CPASSWORD,user.cpassword)
        // Inserting Row
        db.insert(TABLE_USER, null, values)
        db.close()
    }
    *//**
     * This method to update user record
     *
     * @param //user
     *//*
    fun updateUser(user: UserData) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_USER_NAME, user.uname)
        values.put(COLUMN_USER_EMAIL, user.email)
        values.put(COLUMN_USER_PASSWORD, user.password)
        values.put(COLUMN_USER_NO,user.unumber)
        values.put(COLUMN_USER_CPASSWORD,user.cpassword)
        // updating row
        db.update(TABLE_USER, values, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }
    *//**
     * This method is to delete user record
     *
     * @param //user
     *//*
    fun deleteUser(user: UserData) {
        val db = this.writableDatabase
        // delete user record by id
        db.delete(TABLE_USER, "$COLUMN_USER_ID = ?",
            arrayOf(user.id.toString()))
        db.close()
    }
    *//**
     * This method to check user exist or not
     *
     * @param //email
     * @return true/false
     *//*
    fun checkUser(email: String): Boolean {
        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase
        // selection criteria
        val selection = "$COLUMN_USER_EMAIL = ?"
        // selection argument
        val selectionArgs = arrayOf(email)
        // query user table with condition
        *//**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         *//*
        val cursor = db.query(TABLE_USER, //Table to query
            columns,        //columns to return
            selection,      //columns for the WHERE clause
            selectionArgs,  //The values for the WHERE clause
            null,  //group the rows
            null,   //filter by row groups
            null)  //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        if (cursorCount > 0) {
            return true
        }
        return false
    }
    *//**
     * This method to check user exist or not
     *
     * @param //email
     * @param //password
     * @return true/false
     *//*
    fun checkUser(email: String, password: String): Boolean {
        // array of columns to fetch
        val columns = arrayOf(COLUMN_USER_ID)
        val db = this.readableDatabase
        // selection criteria
        val selection = "$COLUMN_USER_EMAIL = ? AND $COLUMN_USER_PASSWORD = ?"
        // selection arguments
        val selectionArgs = arrayOf(email, password)
        // query user table with conditions
        *//**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         *//*
        val cursor = db.query(TABLE_USER, //Table to query
            columns, //columns to return
            selection, //columns for the WHERE clause
            selectionArgs, //The values for the WHERE clause
            null,  //group the rows
            null, //filter by row groups
            null) //The sort order
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        if (cursorCount > 0)
            return true
        return false
    }*/
   /* companion object {
        // Database Version
        private val DATABASE_VERSION = 1
        // Database Name
        private val DATABASE_NAME = "UserManager.db"
        // User table name
        private val TABLE_USER = "user"
        // User Table Columns names
        private val COLUMN_USER_ID = "user_id"
        private val COLUMN_USER_NAME = "user_name"
        private val COLUMN_USER_EMAIL = "user_email"
        private val COLUMN_USER_PASSWORD = "user_password"
        private val COLUMN_USER_NO ="user_number"
        private val COLUMN_USER_CPASSWORD ="user_cpassword"
    }*/
