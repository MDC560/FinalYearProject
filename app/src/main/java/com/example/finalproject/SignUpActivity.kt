package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.ui.login.LoginFragment
import com.example.finalproject.ui.signup.SignUpFragment

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferenceHelper.getSharedPreference(this);
        setContentView(R.layout.activity_sign_up)
        if(SharedPreferenceHelper.getIsSignUp())
        {
            supportFragmentManager.beginTransaction().add(R.id.fragmentcontainer_view_signup,LoginFragment()).commit()
        }
        else
        {
            supportFragmentManager.beginTransaction().add(R.id.fragmentcontainer_view_signup,SignUpFragment()).commit()
        }

    }
}