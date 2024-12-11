package com.example.android_roomdao

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.android_roomdao.models.User
import com.example.android_roomdao.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    // LiveData pour observer la liste des utilisateurs
    val allUsers: LiveData<List<User>> = userRepository.getAllUsers()

    // Méthode pour ajouter un utilisateur (exemple)
    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }

    // Méthode pour mettre à jour un utilisateur existant
    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.update(user)
        }
    }
}
