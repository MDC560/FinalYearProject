package com.example.finalproject.util

import android.app.TimePickerDialog
import android.content.Context
import java.util.*

class DataPickerHelper(val context:Context,val timeListener :TimePickerDialog.OnTimeSetListener) {



    fun showDataAndTime(){
        val myCalender = Calendar.getInstance()
        TimePickerDialog(context,timeListener,myCalender.get(Calendar.HOUR_OF_DAY),
            myCalender.get(Calendar.MINUTE), true).show()
    }


}