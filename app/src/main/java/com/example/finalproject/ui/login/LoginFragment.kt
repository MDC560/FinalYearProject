package com.example.finalproject.ui.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.data.local.database.AppDatabase
import com.example.finalproject.data.local.model.User
import com.example.finalproject.databinding.FragmentLoginBinding
import com.example.finalproject.databinding.FragmentMainBinding

class LoginFragment : Fragment() {

    lateinit var loginViewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        SharedPreferenceHelper.getSharedPreference(requireContext())
       return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGo.setOnClickListener {
            val uEmail=binding.etEmail.text.toString()
                val uPassword=binding.etPassword.text.toString()

                if (uPassword.isEmpty() ||uEmail.isEmpty()){
                    Toast.makeText(requireActivity(), "Please fill in all feilds.",Toast.LENGTH_SHORT).show()
                }
            else
                {
                    val userInfo=loginViewModel.getUserByEmailIdAndPassword(requireContext(),uEmail,uPassword)
                    Log.d(TAG, "onViewCreated: "+userInfo.toString())
                    Log.d(TAG, "onViewCreated: "+userInfo.toString())

                    userInfo?.let {user->
                        SharedPreferenceHelper.setUserId(user.id)
                        startActivity(Intent(requireActivity(),MainActivity::class.java))
                    }



                }



            }

        }


}

