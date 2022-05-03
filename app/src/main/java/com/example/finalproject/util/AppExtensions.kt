package com.example.finalproject.util

import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast

fun Context.showToast(msg:String)
{
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
fun Context.showDateAndTimePicker(timeSetListener: TimePickerDialog.OnTimeSetListener)
{
    val datePickerHelper = DataPickerHelper(this,timeSetListener)
    datePickerHelper.showDataAndTime()
}