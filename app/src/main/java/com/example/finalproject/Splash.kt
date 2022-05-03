package com.example.finalproject//package com.example.finalproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.databinding.FragmentSplashBinding

class Splash : AppCompatActivity() {

    lateinit var binding: FragmentSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.fragment_splash)

SharedPreferenceHelper.getSharedPreference(this)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            Log.d(TAG, "onCreate: "+SharedPreferenceHelper.getUserId())
            if(SharedPreferenceHelper.getUserId()>0)
            {
                val loginFragment = Intent(this,MainActivity::class.java)

                startActivity(loginFragment)
            }
            else{

                val loginFragment = Intent(this, SignUpActivity::class.java)

                startActivity(loginFragment)
            }


        }, 3000)


    }
}

