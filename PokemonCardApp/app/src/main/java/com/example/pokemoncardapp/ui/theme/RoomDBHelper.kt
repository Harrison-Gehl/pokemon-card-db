package com.example.pokemoncardapp.ui.theme

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


//https://developer.android.com/training/data-storage/room/accessing-data#kotlin
@Dao
interface UserDao {
    @Insert
    fun insertAll()

    @Delete
    fun delete()

/*    @Query("SELECT * FROM ")
    fun getAll(): List<>*/
}
