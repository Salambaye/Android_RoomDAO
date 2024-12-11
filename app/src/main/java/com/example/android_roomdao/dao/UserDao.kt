package com.example.android_roomdao.dao

    import androidx.lifecycle.LiveData
    import androidx.room.Dao
    import androidx.room.Insert
    import androidx.room.Query
    import androidx.room.Delete
    @Dao
    interface UserDao {
        @Insert
        suspend fun insert(user: User)
        @Query("SELECT * FROM user_table ORDER BY name ASC")
        fun getAllUsers(): LiveData<List<User>>
        @Delete
        suspend fun deleteUser(user: User)
        // Met à jour un utilisateur existant
        @Update
        suspend fun updateUser(user: User) // Ajout de la méthode de mise à jour
    }
