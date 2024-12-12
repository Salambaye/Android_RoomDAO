package com.example.android_roomdao

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_roomdao.repository.UserRepository
import kotlinx.coroutines.launch
import com.example.android_roomdao.models.User

// The repository abstracts the details of where the data comes from. Here its The UserDao
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val allUsers: LiveData<List<com.example.android_roomdao.models.User>> = repository.allUsers

    fun insert(user: com.example.android_roomdao.User) {
        viewModelScope.launch {
            repository.insert(user)
        }
    }

    fun insertAll(users: List<com.example.android_roomdao.User>) {
        viewModelScope.launch {
            repository.insertAll(users)
        }
    }

    fun delete(user: User) {
        viewModelScope.launch {
            repository.delete(user)
        }
    }
}