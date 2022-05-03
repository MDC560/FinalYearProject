package com.example.finalproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodItem")
data class UserFoodItem (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L, val userId : Long = 0L,

    val name: String, val date: String, val totalCals: Int

        )
