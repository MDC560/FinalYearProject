package com.example.finalproject.ui.glucose

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.data.local.database.AppDatabase
import com.example.finalproject.data.local.model.UserBloodGlucose
import com.example.finalproject.databinding.FragmentBloodGlucoseBinding
import com.example.finalproject.util.hideKeyboard
import java.util.*


class BloodGlucoseFragment : Fragment() {
    lateinit var binding: FragmentBloodGlucoseBinding
    lateinit var sharedPrefs: SharedPreferences
    lateinit var bloodGlucoseModel : BloodGlucoseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_blood_glucose, container, false)
        bloodGlucoseModel = ViewModelProvider(this)[BloodGlucoseViewModel
        ::class.java]

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_blood_glucose, container, false)
        sharedPrefs = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        val date = Date().toString()



        binding.btnSubmit.setOnClickListener {
            it.hideKeyboard()
            val inputValue = binding.hbScore.text.toString().toFloat()// Getting value from edit text
            if (TextUtils.isEmpty(binding.hbScore.text)){
                Toast.makeText(requireActivity(), "Please enter a valid score.", Toast.LENGTH_SHORT).show()




            }

            else{
                val glucoseLevel = UserBloodGlucose(date = date, bloodGlucose = inputValue) //CHECK INPUT VAL ON DATE

                bloodGlucoseModel.insertData(requireContext(), glucoseLevel)
                if (inputValue<=4.0){
                    showAlertDialog(title = "Low sugar levels", message = "Please seek medical attention from your care provider.")
                }
                else if (inputValue>=7.1){
                    showAlertDialog(title = "High sugar levels", message = "Please seek medical attention, your blood sugar is high.")
                }
                else{
                    showAlertDialog(title = "Great", message = "Keep up the great work, your blood sugar is within a normal range.")
                }
                clear()


            }
        }


        return binding.root
    }

    fun showAlertDialog(title: String, message: String) {
        AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"
            ) { dialog, which -> dialog?.cancel() }.create().show()
    }
    fun clear(){
        binding.hbScore.text = null
    }
}
