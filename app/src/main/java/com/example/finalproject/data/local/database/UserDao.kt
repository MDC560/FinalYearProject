package com.example.finalproject.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalproject.data.local.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User ")
    fun getAllUsers (): LiveData<List<User>>
    @Query (" SELECT * FROM User WHERE id =:id" )
    fun getUserByID(id:Long):LiveData<User>

    @Query (" SELECT * FROM User WHERE email =:email and password=:password" )
    fun getUserByEmailPassword(email:String, password:String):User



}