package com.example.permissionex

import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var img1:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        img1 = findViewById(R.id.img)

        if(checkSelfPermission(CAMERA)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA),1)
        }

        btn1.setOnClickListener {

            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            //Class - Bitmap-offline images
            //Online - Picasso

            var bm :Bitmap = data!!.extras!!.get("data") as Bitmap
            img1.setImageBitmap(bm)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}