package com.example.android_roomdao.repository

import androidx.lifecycle.LiveData
import com.example.android_roomdao.dao.UserDao
import com.example.android_roomdao.models.User


class UserRepository(private val userDao: UserDao) {

    // Retourne tous les utilisateurs
    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()

    // Insère un utilisateur dans la base de données
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    // Met à jour un utilisateur dans la base de données
    suspend fun update(user: User) {
        userDao.updateUser(user)
    }
}

/*
class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
    suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }
}
*/
