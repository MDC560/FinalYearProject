package com.example.finalproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BloodGlucose")
data class UserBloodGlucose (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L, val userId : Long = 0L,

    val date: String, val bloodGlucose: Float,


        )
