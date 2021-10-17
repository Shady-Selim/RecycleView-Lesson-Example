package com.shady.recycleviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRecycleViewAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_item, parent,false)
        return UserAdapter.ViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserAdapter.ViewHolder,
                                  position: Int) {
        val user = userList[position]
        holder.idTextView.text = user.id.toString()
        holder.nameTextView.text = "${user.fName} ${user.lName}"
        holder.scoreTextView.text = user.score.toString()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserAdapter{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(
        itemView){
        val idTextView: TextView = itemView.findViewById(R.id.tvId)
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val scoreTextView: TextView = itemView.findViewById(R.id.tvScore)
    }
}
