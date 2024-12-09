package tops.tech.roomdbex.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tops.tech.roomdbex.Adapter.UserAdapter
import tops.tech.roomdbex.Database.DatabaseClass

import tops.tech.roomdbex.Entity.User

import tops.tech.roomdbex.R

class MainActivity : AppCompatActivity()
{
    lateinit var f1: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<User>
    lateinit var db: DatabaseClass
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f1 = findViewById(R.id.f1)
        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        var l1: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=l1


        list =  db.daoClass().getUsers()

        var adapter = UserAdapter(applicationContext,list)
        recyclerView.adapter=adapter



        f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))

        }
    }
}