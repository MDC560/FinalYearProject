package com.example.finalproject.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.UserExercise
import com.example.finalproject.data.local.repository.AppRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChartViewModel : ViewModel() {
    var liveDataExercise = MutableLiveData<List<UserExercise>>()
    fun getListOfActivitiesByUserId(context: Context, userId:Long)
    {
        CoroutineScope(Dispatchers.IO).launch {
            val listofActivities = AppRepository.getUserActivitiesByUserId(context,userId)
            listofActivities?.let {
                liveDataExercise.postValue(it)
            }
        }


    }
}