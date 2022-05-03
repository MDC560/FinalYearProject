package com.example.finalproject.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.finalproject.R
import java.util.*

object SharedPreferenceHelper {

    val KEY_INSULIN="insulin_key"
    val KEY_METFORMIN="metforminstock_key"
    val KEY_STRIP="test_strip_key"
    val IS_LOGIN = "login_key"
    val IS_SIGN_UP = "signup_key"
    val KEY_DOSAGE = "daily_dosage"
    val KEY_DATE = "dosage_date"
    val KEY_TIME = "dosage_time"
    val KEY_USER_ID="user_id";

    lateinit var  sharedPreferences: SharedPreferences
    lateinit var editor:SharedPreferences.Editor

    fun getSharedPreference(context:Context)
    {

        sharedPreferences= context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        editor= sharedPreferences.edit()
    }

    fun saveDaily_dose(dailyDose:Int)
    {
        editor.putInt(KEY_DOSAGE,dailyDose).commit()
    }
    fun getDailyDose():Int
    {
        return sharedPreferences.getInt(KEY_DOSAGE,0)
    }

    fun saveInsulinStock(insulinDoses:Int)
    {
        editor.putInt(KEY_INSULIN,insulinDoses).commit()
    }
    fun getInsulinStock():Int
    {
        return sharedPreferences.getInt(KEY_INSULIN,0)
    }

    fun saveMetforminStock(metforminDoses:Int)
    {
        editor.putInt(KEY_METFORMIN,metforminDoses).commit()
    }
    fun getMetforminStock():Int
    {
        return sharedPreferences.getInt(KEY_METFORMIN,0)
    }
    fun saveTestStripStock(TestStripDoses:Int)
    {
        editor.putInt(KEY_STRIP,TestStripDoses).commit()
    }
    fun getTestStripStock():Int
    {
        return sharedPreferences.getInt(KEY_STRIP,0)
    }
    fun saveIS_LOGIN(islogin:Boolean)
    {
        editor.putBoolean(IS_LOGIN,islogin).commit()
    }
    fun getIsLogin():Boolean
    {
        return sharedPreferences.getBoolean(IS_LOGIN,false)

    }fun IS_SIGN_UP(isSignUp:Boolean)
    {
        editor.putBoolean(IS_SIGN_UP,isSignUp).commit()
    }
    fun getIsSignUp():Boolean
    {
        return sharedPreferences.getBoolean(IS_SIGN_UP,false)
    }
    fun setUserId(userId:Long)
    {
        editor.putLong(KEY_USER_ID,userId).commit()
    }
    fun getUserId():Long
    {
        return sharedPreferences.getLong(KEY_USER_ID,0)
    }

}