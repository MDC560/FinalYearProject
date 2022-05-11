package com.example.finalproject.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.local.model.UserExercise

class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val activityName = view.findViewById<TextView>(R.id.tv_activity_name)
    val activityTime = view.findViewById<TextView>(R.id.tv_time)
    fun onBind(userExcercise:UserExercise)
    {
        activityName.text = userExcercise.name
        activityTime.text =userExcercise.time
    }

}