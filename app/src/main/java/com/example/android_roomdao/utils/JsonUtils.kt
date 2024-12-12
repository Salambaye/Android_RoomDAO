package com.example.android_roomdao.utils  // Remplacez par le package approprié

import android.content.Context
import com.example.android_roomdao.models.User  // Assurez-vous d'importer la classe User
import com.example.android_roomdao.R
import org.json.JSONObject

fun parseJson(context: Context): List<User> {
    val users = mutableListOf<User>()

    // Ouvrir le fichier raw (res/raw/users.json)
    val jsonString = context.resources.openRawResource(R.raw.users).bufferedReader().use { it.readText() }

    // Analyser le fichier JSON
    val jsonArray = JSONObject(jsonString).getJSONArray("users")

    // Pour chaque objet dans le tableau, créer un objet User et l'ajouter à la liste
    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        users.add(
            User(
                name = jsonObject.getString("name"),
                email = jsonObject.getString("email")
            )
        )
    }
    return users
}

