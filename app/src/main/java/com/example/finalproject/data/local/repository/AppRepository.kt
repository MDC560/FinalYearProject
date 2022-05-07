package com.example.finalproject.data.local.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.finalproject.data.local.database.AppDatabase
import com.example.finalproject.data.local.model.*
import com.example.finalproject.ui.login.LoginViewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AppRepository {
    companion object {
        var loginDatabase: AppDatabase? = null
        fun initializeDB(context: Context) : AppDatabase {
            return AppDatabase.getInstance(context)
        }
        fun insertData(context: Context, user: User) {
            loginDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                loginDatabase!!.userDao.insertUser(user);
            }
        }
        fun insertExercise(context: Context, exercise: UserExercise) {
            loginDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                loginDatabase!!.userActivitiesDao.insertUserActivities(exercise);
            }
        }
        fun insertFoodItem(context: Context, foodItem:List <UserFoodItem>) {
            loginDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                loginDatabase!!.userFoodItemDao.AddFoodItem(foodItem);
            }
        }
        fun insertBloodGlucose(context: Context, bloodGlucose: UserBloodGlucose) {
            loginDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                loginDatabase!!.userBloodGlucoseDao.insertUserBloodGlucose(bloodGlucose);
            }
        }
        fun insertMedicine(context: Context, medicine: UserMedicine) {
            loginDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                loginDatabase!!.userMedicineDao.insertUserMedicine(medicine);
            }
        }
        fun getUser(context: Context, emailId: String, password: String) :User?{
            loginDatabase = initializeDB(context)
            return loginDatabase!!.userDao.getUserByEmailPassword(emailId, password)
        }
    }
}