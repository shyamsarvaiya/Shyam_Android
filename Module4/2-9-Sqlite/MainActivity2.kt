package tops.tech.sqlitedbex1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity2 : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    var arraylist:ArrayList<HashMap<String,String>> = ArrayList()
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById(R.id.list)
        list = ArrayList()
        dbHelper = DbHelper(applicationContext)
        list = dbHelper.viewdata()

        for(i in list)
        {
            var hm = HashMap<String,String>()
            hm["NAME"]=i.name
            hm["NUM"]=i.num

            arraylist.add(hm)
        }

        var from = arrayOf("NAME","NUM")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        listView.adapter = adapter


    }
}