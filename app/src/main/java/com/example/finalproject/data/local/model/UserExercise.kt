package com.example.finalproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Activities")
data class UserExercise (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L, val userId: Long = 0L,

    val burntCalories: Int, val time: Int, val type: String, val name: String
        )
