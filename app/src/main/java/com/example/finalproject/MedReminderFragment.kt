package com.example.finalproject

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.callback.DialogCallBack
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.databinding.FragmentMedReminderBinding
import com.example.finalproject.util.showDateAndTimePicker
import java.util.*


class MedReminderFragment : Fragment() {
    lateinit var binding: FragmentMedReminderBinding
    var num = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_med_reminder, container, false)
        SharedPreferenceHelper.getSharedPreference(requireContext())
        binding.tvDosageCount.setText(SharedPreferenceHelper.getDailyDose().toString())
        var currentValue = SharedPreferenceHelper.getDailyDose()
        SharedPreferenceHelper.saveDaily_dose(currentValue)


        val myCalender = Calendar.getInstance()
        val dateListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalender)
        }

        binding.btnDatePicker.setOnClickListener {
            val myCalender = Calendar.getInstance()
            DatePickerDialog(requireActivity(),dateListener,myCalender.get(Calendar.YEAR),myCalender.get(Calendar.MONTH),myCalender.get(Calendar.DAY_OF_MONTH))
                .show()
        }


        val timeListener = TimePickerDialog.OnTimeSetListener{ timePicer, hourOfDay, minute ->
            val myCalender = Calendar.getInstance()
            myCalender.set(Calendar.HOUR_OF_DAY,hourOfDay)
            myCalender.set(Calendar.MINUTE, minute)
            updateTimeLabel(myCalender)
        }

        binding.btnTimePicker.setOnClickListener {
            requireActivity().showDateAndTimePicker(timeListener)

        }

        binding.btnConfirm.setOnClickListener {
            Toast.makeText(requireActivity(),"Button clicked!",Toast.LENGTH_LONG)


        }


        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateTimeLabel(myCalender: Calendar) {
        val myFormat = "HH:mm"
        val updatedTimeString = SimpleDateFormat(myFormat).format((myCalender.time))
        binding.selectTimeLabelTv.text = updatedTimeString
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLable(myCalender: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val updatedDateString = SimpleDateFormat(myFormat, Locale.ENGLISH).format((myCalender.time))
        binding.tvSelectDate.text = updatedDateString
    }



}