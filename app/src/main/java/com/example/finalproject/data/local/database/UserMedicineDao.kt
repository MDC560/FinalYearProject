package com.example.finalproject.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.local.model.UserMedicine

@Dao
interface UserMedicineDao {
    @Insert
    suspend fun insertUserMedicine(user: UserMedicine)

    @Query("SELECT * FROM Medicine ")
    fun getAllMedicine (): List<UserMedicine>
    @Query (" SELECT * FROM Medicine WHERE userId =:id" )
    fun medicineList(id:Long): List<UserMedicine>

}