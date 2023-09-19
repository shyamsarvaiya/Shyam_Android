package tops.tech.roomdbex.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import tops.tech.roomdbex.Entity.User

import tops.tech.roomdbex.R

class UserAdapter(var context:Context,var userList: MutableList<User>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var layout = LayoutInflater.from(context)
       var view = layout.inflate(R.layout.design,parent,false)
       return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.name.setText(userList.get(position).username)
        holder.email.setText(userList.get(position).useremail)


    }


}
class MyView(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val name: TextView
    val email: TextView

    init
    {
        name = itemView.findViewById<TextView>(R.id.name)
        email = itemView.findViewById<TextView>(R.id.email)
    }
}