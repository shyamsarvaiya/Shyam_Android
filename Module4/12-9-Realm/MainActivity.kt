package tops.tech.realmdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var realm:Realm

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        btn1.setOnClickListener {

            var name11 = edt1.text.toString()
            var num11 = edt2.text.toString()

            realm.beginTransaction()

                var m = realm.createObject(Model::class.java)
                m.name=name11
                m.num=num11


            realm.commitTransaction()

            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext,MainActivity2::class.java))


        }
        btn2.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}