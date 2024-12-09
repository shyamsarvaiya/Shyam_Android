package tops.tech.sqlitedbex1

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog

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
        registerForContextMenu(listView)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var data = acm.position
        var m = list[data]

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("ID",m.id)
                i.putExtra("NAME",m.name)
                i.putExtra("NUMBER",m.num)
                startActivity(i)
            }
            2->
            {
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->


                    dbHelper.deletedata(m.id)
                    startActivity(Intent(applicationContext,MainActivity2::class.java))

                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alertDialog.show()
            }

        }


        return super.onContextItemSelected(item)
    }
}