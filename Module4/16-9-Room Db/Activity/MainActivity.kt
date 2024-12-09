package tops.tech.roomdbex.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tops.tech.roomdbex.R

class MainActivity : AppCompatActivity()
{
    lateinit var f1:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f1 = findViewById(R.id.f1)

        f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))

        }

    }
}