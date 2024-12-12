package com.example.android_roomdao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_roomdao.R
import com.example.android_roomdao.models.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList: List<User> = emptyList()

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            val nameTextView: TextView = itemView.findViewById(R.id.name)
            val emailTextView: TextView = itemView.findViewById(R.id.email)

            nameTextView.text = user.name
            emailTextView.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = userList.size

    fun setUsers(users: List<com.example.android_roomdao.models.User>) {
        userList = users
        notifyDataSetChanged()
    }
}