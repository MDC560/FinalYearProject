package com.example.finalproject.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.local.model.UserExercise

@Dao
interface  UserExerciseDao {
    @Insert
    suspend fun insertUserActivities(exercise: UserExercise)

    @Query("SELECT * FROM Activities ")
     fun getAllActivities (): List<UserExercise>
    @Query (" SELECT * FROM Activities WHERE userId =:userId" )
     fun activitiesList(userId:Long): List<UserExercise>

}