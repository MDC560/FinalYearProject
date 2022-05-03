package com.example.finalproject.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalproject.data.local.model.*

@Database(entities = [User::class, UserFoodItem::class, UserExercise::class, UserBloodGlucose::class,  UserMedicine::class], version = 7, exportSchema = false) //expert schema version history in your code base.
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao //returns data access object
    abstract val userFoodItemDao: UserCaloriesDao //returns data access object
    abstract val userActivitiesDao: UserExerciseDao //returns data access object
    abstract val userBloodGlucoseDao: UserBloodGlucoseDao //returns data access object
    abstract val userMedicineDao: UserMedicineDao //returns data access object

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "App_database"
                        ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}