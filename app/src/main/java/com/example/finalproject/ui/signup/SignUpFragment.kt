package com.example.finalproject.ui.signup

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.TypeFragment
import com.example.finalproject.data.local.database.AppDatabase
import com.example.finalproject.data.local.model.User
import com.example.finalproject.databinding.FragmentMainBinding
import com.example.finalproject.util.showToast
import java.util.*


class SignUpFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var sharedPrefs: SharedPreferences
    lateinit var signUpViewModel: SignUpViewModel

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLable(myCalender: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val updatedDateString = SimpleDateFormat(myFormat, Locale.ENGLISH).format((myCalender.time))
        binding.etdob.text = updatedDateString
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        signUpViewModel = ViewModelProvider(this)[SignUpViewModel:: class.java]

        sharedPrefs = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
        val myCalender = Calendar.getInstance()
        val dateListener = DatePickerDialog.OnDateSetListener{ datePicker, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH,month)
            myCalender.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(myCalender)
        }

        binding.etdob.setOnClickListener(View.OnClickListener {
            val myCalender = Calendar.getInstance()
            DatePickerDialog(requireActivity(), dateListener,myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH)).show()

        })



        binding.btnGo.setOnClickListener(View.OnClickListener {
            val email = binding.etEmail.text.toString()
            val name = binding.etFname.text.toString()
            val dob = binding.etdob.text.toString()
            val weight = binding.etWeight.text.toString().toInt()
            val height = binding.etHeight.text.toString().toInt()
            val password = binding.etPassword.text.toString()

            if (email.isNotBlank()) {
                if (name.isNotBlank()) {
                    if (dob.isNotBlank()) {
                        if (weight > 0) {
                            if (height > 0) {
                                if (password.isNotBlank()){
                                    val user = User(name = name, email = email, dateOBirth = dob, weight = weight, height = height, password = password )
                                    signUpViewModel.insertData(requireActivity(), user)

                                    with(sharedPrefs.edit()) {
                                        putString(getString(R.string.name_key), name)
                                        apply()
                                    }

                                    requireActivity().supportFragmentManager
                                        .beginTransaction()
                                        .replace(R.id.fragmentcontainer_view_signup, TypeFragment())
                                        .addToBackStack(null)
                                        .commit()
                                } else {

                                requireActivity().showToast("Enter height!")
                            }
                        } else {
                            requireActivity().showToast("Enter weight!")

                        }
                    } else {
                        requireActivity().showToast("Enter date of birth!")

                    }
                } else {
                    requireActivity().showToast("Enter a valid name!")

                }
            } else {

                requireActivity().showToast("Enter a valid email!")
                }



        }
    })
        return binding.root
    }
}

