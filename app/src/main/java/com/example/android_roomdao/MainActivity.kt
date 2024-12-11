package com.example.android_roomdao

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialiser le RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        userAdapter = UserAdapter()
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observer les données LiveData
        userViewModel.allUsers.observe(this, Observer { users ->
            users?.let {
                userAdapter.setUsers(it)
            }

        })
    }
}