package com.example.finalproject.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalproject.data.local.model.User
import com.example.finalproject.data.local.repository.AppRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var liveDataLogin = MutableLiveData<User?>()

    fun getUserByEmailIdAndPassword(
        context: Context,
        email: String, password: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val userInfo = AppRepository.getUser(context, email, password)
            liveDataLogin.postValue(userInfo)
        }

    }
}