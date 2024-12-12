package com.example.android_roomdao.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.android_roomdao.dao.UserDao
import com.example.android_roomdao.database.UserDatabase
import com.example.android_roomdao.models.User

// Le Repository sert d'abstraction pour accéder aux données
// Il est responsable de l'interaction avec le DAO (Data Access Object)
// Il cache les données pour une gestion plus simple et plus flexible.
class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()
    suspend fun insert(user: com.example.android_roomdao.User) {
        userDao.insert(user)
    }
    suspend fun delete(user: User) {
        userDao.deleteUser(user)
    }
    suspend fun insertAll(users: List<com.example.android_roomdao.User>) {
        userDao.insertAll(users)
    }

    companion object {
        fun getRepository(context: Context): UserRepository {
            val database = UserDatabase.getDatabase(context)
            return UserRepository(database.userDao())
        }
    }
}
