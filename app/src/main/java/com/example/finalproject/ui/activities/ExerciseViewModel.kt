package com.example.finalproject.ui.activities

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.UserExercise
import com.example.finalproject.data.local.repository.AppRepository

class ExerciseViewModel : ViewModel() {



    fun insertData(context: Context,exercise: UserExercise) {
        AppRepository.insertExercise(context, exercise)
    }




    }