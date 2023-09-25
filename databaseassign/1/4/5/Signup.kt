package com.example.work_management

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

@Suppress("DEPRECATION")
class Signup : AppCompatActivity() {

    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var editText3: EditText
    lateinit var editText4: EditText
    lateinit var editText5: EditText

    lateinit var imageView: ImageView

    lateinit var submit:Button

    lateinit var imagepath:Uri
    lateinit var imagetostore:Bitmap

    private lateinit var db:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        db = DatabaseHelper(this)

        editText1 = findViewById(R.id.edit1)
        editText2 = findViewById(R.id.edit2)
        editText3 = findViewById(R.id.edit3)
        editText4 = findViewById(R.id.edit4)
        imageView = findViewById(R.id.image)
        editText5 = findViewById(R.id.edit5)

        submit = findViewById(R.id.signup)



        imageView.setOnClickListener {

                choseImage()

        }

        submit.setOnClickListener {


            val uname= editText1.text.toString()
            val pass= editText2.text.toString()
            val cpass= editText3.text.toString()
            val no= editText4.text.toString()
            val email= editText5.text.toString()

            var save=  db.insertdata(ModelClass(imagetostore, uname,pass,cpass,no,email))

            if(editText1.text.toString().isEmpty() && editText2.text.toString()
                    .isEmpty() && editText3.text.toString().isEmpty() &&
                editText4.text.toString().isEmpty() &&
                editText5.text.toString().isEmpty() && imageView.drawable != null
            ) {

                Toast.makeText(this, "Fill Up all Details", Toast.LENGTH_LONG).show()
            }
            else
            {
                if(pass == cpass)
                {
                    if(save != null)
                    {
                        Toast.makeText(this,"SignUp Success",Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext,Login::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,"User Exists",Toast.LENGTH_LONG).show()
                    }
                }
                else
                {
                    Toast.makeText(this,"Password Wrong",Toast.LENGTH_LONG).show()
                }
            }
            /*   val uname= editText1.text.toString()
            val pass= editText2.text.toString()
            val cpass= editText3.text.toString()
            val no= editText4.text.toString()
            val email= editText5.text.toString()
*/

            //  val save = db.insertdata(uname,pass,cpass,no,email,image)

            /*if(TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass) ||
                TextUtils.isEmpty(cpass) || TextUtils.isEmpty(no) ||
                TextUtils.isEmpty(email))
            {
                Toast.makeText(this,"Fill Up all Details",Toast.LENGTH_LONG).show()
            }
            else
            {
                if(pass == cpass)
                {
                    if(save == true)
                    {
                        Toast.makeText(this,"SignUp Success",Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext,Login::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this,"User Exists",Toast.LENGTH_LONG).show()
                    }
                }
                else
                {
                    Toast.makeText(this,"Password Wrong",Toast.LENGTH_LONG).show()
                }
            }*/
        }
    }
    private fun choseImage()
    {
        try {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,1)

        }catch (e: Exception)
        {
            Toast.makeText(applicationContext, e.message,Toast.LENGTH_LONG).show()
        }
    }
   /* private fun storeimage()
    {
        if(editText1.text.toString().isEmpty() && editText2.text.toString()
                .isEmpty() && editText3.text.toString().isEmpty() &&
            editText4.text.toString().isEmpty() &&
            editText5.text.toString().isEmpty() && imageView.drawable != null
        )
        {

            Toast.makeText(this,"Fill Up all Details",Toast.LENGTH_LONG).show()

           *//* db.insertdata(ModelClass(imagetostore, editText1.toString(),editText2.toString(),editText3.toString(),editText4.toString(),editText5.toString()))
            Toast.makeText(this,"SignUp Success",Toast.LENGTH_LONG).show()
            val intent = Intent(applicationContext,Login::class.java)
            startActivity(intent)*//*
        }

        else{
            if(editText2 == editText3)
            {
                Toast.makeText(this,"SignUp Success",Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext,Login::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Not Add",Toast.LENGTH_LONG).show()
            }
        }
    }*/

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        try
        {
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.data != null)
            {
                imagepath = data.data!!
                imagetostore = MediaStore.Images.Media.getBitmap(contentResolver,imagepath)
                imageView.setImageBitmap(imagetostore)
            }

        }
        catch (e:Exception)
        {
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }
}