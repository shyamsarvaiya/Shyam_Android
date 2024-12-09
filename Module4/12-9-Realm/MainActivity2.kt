package tops.tech.realmdb

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.realm.Realm

class MainActivity2 : AppCompatActivity()
{
    lateinit var realm: Realm
    lateinit var list:MutableList<Model>
    lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        realm =Realm.getInstance(Realm.getDefaultConfiguration())
        list = ArrayList()
        listView = findViewById(R.id.list)

        realm.beginTransaction()

        var realmResults = realm.where(Model::class.java).findAll()

        for(i in realmResults.indices)
        {
            list.add(realmResults[i]!!)
        }

        var myAdapter = MyAdapter(applicationContext,list)
        listView.adapter=myAdapter


        realm.commitTransaction()

        listView.setOnItemClickListener { parent, view, position, id ->


            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Select Operations?")
            alertDialog.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                realm.beginTransaction()

                var alertDialog2=AlertDialog.Builder(this)
                var inflater= LayoutInflater.from(this)
                var view = inflater.inflate(R.layout.edit,null)
                var edt1:EditText = view.findViewById(R.id.edt1)
                var edt2:EditText = view.findViewById(R.id.edt2)
                edt1.setText(list.get(position).name)
                edt2.setText(list.get(position).num)
                alertDialog2.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                    realm.beginTransaction()

                    var name =edt1.text.toString()
                    var num=edt2.text.toString()

                    list.get(position).name =name
                    list.get(position).num = num

                    realm.commitTransaction()

                    startActivity(Intent(this,MainActivity2::class.java))
                })
                alertDialog2.setView(view)
                alertDialog2.show()
                realm.commitTransaction()




            })
            alertDialog.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                realm.beginTransaction()

                var realmResults = realm.where(Model::class.java).findAll()
                realmResults.deleteFromRealm(position)
                realm.commitTransaction()
                startActivity(Intent(applicationContext, MainActivity2::class.java))

            })
            alertDialog.show()


        }

    }
}