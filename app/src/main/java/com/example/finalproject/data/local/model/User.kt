package com.example.finalproject.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,

    val name: String, val email: String, val dateOBirth : String, val weight: Int, val height: Int, val password: String = "android"
        )