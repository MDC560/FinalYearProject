package com.example.finalproject.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.local.model.UserBloodGlucose
@Dao
interface  UserBloodGlucoseDao{
    @Insert
    suspend fun insertUserBloodGlucose(user: UserBloodGlucose)

    @Query("SELECT * FROM BloodGlucose ")
    fun getAllBlood (): List<UserBloodGlucose>
    @Query(" SELECT * FROM BloodGlucose WHERE userId =:id" )
    fun bloodGlucoseList(id:Long): List<UserBloodGlucose>

}