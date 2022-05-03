package com.example.finalproject.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.User
import com.example.finalproject.data.local.repository.AppRepository

class LoginViewModel : ViewModel() {

    var liveDataLogin: LiveData<User>? = null

    fun getUserByEmailIdAndPassword(context: Context,
        email : String, password : String
    ):User?{
           return AppRepository.getUser(context, email, password)
    }

    }