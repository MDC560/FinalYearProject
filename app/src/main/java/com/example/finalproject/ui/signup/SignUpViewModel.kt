package com.example.finalproject.ui.signup

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.User
import com.example.finalproject.data.local.repository.AppRepository

class SignUpViewModel : ViewModel() {

    var liveDataLogin: LiveData<User>? = null

    fun insertData(context: Context,user: User) {
        AppRepository.insertData(context,user)
    }

    }