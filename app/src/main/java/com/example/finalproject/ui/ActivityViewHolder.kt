package com.example.finalproject.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.local.model.UserExercise

class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var textView = view.findViewById<TextView>(R.id.tv_activity_name)
    fun onBind(userExcercise:UserExercise)
    {
        textView.text = userExcercise.name
    }

}