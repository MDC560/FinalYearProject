package com.example.finalproject.ui.activities

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
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
import com.example.finalproject.data.ViewPagerData
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.data.local.database.AppDatabase
import com.example.finalproject.data.local.model.UserExercise
import com.example.finalproject.databinding.FragmentExerciseBinding
import com.example.finalproject.ui.login.LoginViewModel

class ExerciseFragment : Fragment() {

    lateinit var binding : FragmentExerciseBinding
    lateinit var sharedPref : SharedPreferences
    lateinit var exerciseViewModel: ExerciseViewModel

    var selectedType = "Moderate"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise, container, false)
        exerciseViewModel = ViewModelProvider(this)[ExerciseViewModel::class.java]


        SharedPreferenceHelper.getSharedPreference(requireContext())

        val options = arrayOf<String>("Select Type","Moderate", "Vigorous")
        val arrayAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_dropdown_item,android.R.id.text1, options)
        binding.EtSpinner.adapter=arrayAdapter

        binding.EtSpinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedType = options[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        sharedPref = requireActivity().getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etModerate.text.toString()
            //ViewPagerData.yourActivities = binding.etModerate.text.toString()
              binding.tvTest.text = name

              val totalTime ="${if(binding.NumPickModHrs.value / 10 > 0)binding.NumPickModHrs.value else "0${binding.NumPickModHrs.value}"}:" +
                      "${if(binding.NumPickModMins.value / 10 > 0)binding.NumPickModMins.value else "0${binding.NumPickModMins.value}"}:" +
                      "${if(binding.numPickModSeconds.value / 10 > 0)binding.numPickModSeconds.value else "0${binding.numPickModSeconds.value}"}"
            binding.tvTotalTime.text = totalTime

            binding.tvTotalDistance.text = selectedType


            val useid = SharedPreferenceHelper.getUserId()


            Log.d(TAG, "onCreateView: "+name+" "+totalTime)
            val activity = UserExercise(burntCalories = 2, userId =useid , time=totalTime, type=selectedType, name = name)
            try {
                exerciseViewModel.insertData(requireContext(), activity)
            }
            catch(e:Exception)
            {
                Log.d(ContentValues.TAG, "onCreateView: "+e.message)

            }

        }
        //Log.d(TAG, "onCreateView: " +burntCals + ""+tTime) //


        //Launch and save



        binding.imgInfo.setOnClickListener {

            showAlertDialog("Activity monitor",
                "According to NHS England adults should aim to do a minimum of 75 minutes of vigorous activity per week, and 150 minutes of moderate activity " +
                        "this should push you to breath hard and fast as you raise your heart rate" +
                        ". Vigorous activity include; running; swimming; high intensity interval training, martial arts. Moderate activity dancing, walking, riding a bicycle and or gardening! ")


        }



        binding.NumPickModHrs.maxValue = 10
        binding.NumPickModHrs.minValue = 0

        binding.NumPickModHrs.setOnClickListener {
            Toast.makeText(requireActivity(), binding.NumPickModHrs.value.toString(), Toast.LENGTH_SHORT).show()

        }
        binding.NumPickModMins.maxValue = 59
        binding.NumPickModMins.minValue = 0

        binding.NumPickModMins.setOnClickListener {
            Toast.makeText(requireActivity(), binding.NumPickModMins.value.toString(), Toast.LENGTH_SHORT).show()

        }

        binding.numPickModSeconds.maxValue = 59
        binding.numPickModSeconds.minValue = 0

        binding.numPickModSeconds.setOnClickListener {
            Toast.makeText(requireActivity(), binding.numPickModSeconds.value.toString(), Toast.LENGTH_SHORT).show()

        }






        return binding.root

    }


    fun clear(){
        binding.EtSpinner.setSelection(0)
        binding.etModerate.text = null
        binding.numPickModSeconds.value = 0
        binding.NumPickModMins.value = 0
        binding.NumPickModHrs.value = 0
    }

    private fun showAlertDialog(title: String, message: String) {
        AlertDialog.Builder(requireActivity())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"
            ) { dialog, _ -> dialog?.cancel() }.create().show()
    }



}