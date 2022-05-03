package com.example.finalproject.ui.calories

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.UserFoodItem
import com.example.finalproject.data.local.repository.AppRepository

class FoodItemViewModel : ViewModel() {

    var liveDataFoodItem: LiveData<UserFoodItem>? = null

    fun insertData(context: Context,foodItem:List <UserFoodItem>) {
        AppRepository.insertFoodItem(context, foodItem)
    }

    }