package tops.tech.roomdbex.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import tops.tech.roomdbex.Database.DatabaseClass
import tops.tech.roomdbex.Entity.User
import tops.tech.roomdbex.R

class AdduserActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var db: DatabaseClass
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var email = edt2.text.toString()

            var u = User()
            u.username=name
            u.useremail=email

            db.daoClass().insertdata(u)
            Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()

        }

    }
}