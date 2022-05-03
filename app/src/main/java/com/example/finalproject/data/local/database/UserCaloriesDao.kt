package com.example.finalproject.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.local.model.UserFoodItem

@Dao
interface UserCaloriesDao {
    @Insert
    suspend fun insertUserFoodItem(user: UserFoodItem)

    @Query("SELECT * FROM FoodItem ")
    fun getAllCalories (): List<UserFoodItem>
    @Query (" SELECT * FROM FoodItem WHERE userId =:id" )
    fun caloriesList(id:Long): List<UserFoodItem>
    @Insert
    suspend fun AddFoodItem(foodItem: List <UserFoodItem> )

}