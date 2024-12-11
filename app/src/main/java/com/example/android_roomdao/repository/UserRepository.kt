package com.example.android_roomdao.repository

import androidx.lifecycle.LiveData

// Le Repository sert d'abstraction pour accéder aux données
// Il est responsable de l'interaction avec le DAO (Data Access Object)
// Il cache les données pour une gestion plus simple et plus flexible.
class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
    suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }
}
