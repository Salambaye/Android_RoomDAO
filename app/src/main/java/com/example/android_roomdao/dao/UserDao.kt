package com.example.android_roomdao.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_roomdao.models.User

@Dao
interface UserDao {
    // Insérer un utilisateur
    @Insert
    suspend fun insert(user: com.example.android_roomdao.User)

    // Insérer plusieurs utilisateurs
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<com.example.android_roomdao.User>)

    // Récupérer tous les utilisateurs
    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAllUsers(): LiveData<List<User>>

    // Supprimer un utilisateur
    @Delete
    suspend fun deleteUser(user: User)

    // Supprimer tous les utilisateurs
    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers(): Int  // Retourne le nombre de lignes supprimées
}
