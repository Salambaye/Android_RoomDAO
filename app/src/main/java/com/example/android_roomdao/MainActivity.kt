package com.example.android_roomdao;

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.userinterfaceapp.R

class MainActivity : AppCompatActivity() {

    // Instance de ViewModel associée à cette activité
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Référence au RecyclerView dans le layout
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val noUsersTextView: TextView = findViewById(R.id.noUsersTextView) // Pour afficher un message si la liste est vide

        // Configuration du RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter() // Adapter personnalisé pour afficher les utilisateurs
        recyclerView.adapter = userAdapter

        // Observation des données utilisateurs dans le ViewModel
        userViewModel.allUsers.observe(this, Observer { users ->
            if (users.isNotEmpty()) {
                // Mettre à jour le RecyclerView avec les données
                userAdapter.submitList(users)
                noUsersTextView.visibility = TextView.GONE // Cacher le message "Pas d'utilisateurs"
                recyclerView.visibility = RecyclerView.VISIBLE
            } else {
                // Afficher un message indiquant qu'il n'y a pas d'utilisateurs
                noUsersTextView.visibility = TextView.VISIBLE
                recyclerView.visibility = RecyclerView.GONE
            }
        })
    }
}







/*

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_roomdao.ui.theme.Android_RoomDAOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_RoomDAOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_RoomDAOTheme {
        Greeting("Android")
    }
}
*/
