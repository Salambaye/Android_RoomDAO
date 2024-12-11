package com.example.android_roomdao.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android_roomdao.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAllUsers(): LiveData<List<User>>
    @Delete
    suspend fun deleteUser(user: User)

    // Méthode pour mettre à jour un utilisateur existant
    @Update
    suspend fun updateUser(user: User)
}