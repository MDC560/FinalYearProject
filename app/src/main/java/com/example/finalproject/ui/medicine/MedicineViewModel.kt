package com.example.finalproject.ui.medicine

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.UserMedicine
import com.example.finalproject.data.local.repository.AppRepository

class MedicineViewModel : ViewModel() {

    var liveDataMedicine: LiveData<UserMedicine>? = null

    fun insertData(context: Context,medicine: UserMedicine) {
        AppRepository.insertMedicine(context,medicine)
    }

    }