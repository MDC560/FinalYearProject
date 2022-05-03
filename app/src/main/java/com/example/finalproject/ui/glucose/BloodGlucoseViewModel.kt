package com.example.finalproject.ui.glucose

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.UserBloodGlucose
import com.example.finalproject.data.local.repository.AppRepository

class BloodGlucoseViewModel : ViewModel() {

    var liveDataBloodGlucose: LiveData<UserBloodGlucose>? = null

    fun insertData(context: Context,bloodGlucose: UserBloodGlucose) {
        AppRepository.insertBloodGlucose(context,bloodGlucose)
    }

    }