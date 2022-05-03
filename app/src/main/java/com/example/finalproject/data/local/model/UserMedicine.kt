package com.example.finalproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medicine")
data class UserMedicine (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L, val userId: Long = 0L,

    val medicineName: String, val insulinStock: Int, val MetforminStock: Int,
)