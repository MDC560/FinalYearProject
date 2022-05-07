package com.example.finalproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.local.model.UserExercise

class ActivityAdapter(val activityList:List<UserExercise>) : RecyclerView.Adapter<ActivityViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity,parent,false)
       return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {

        val userExercise = activityList.get(position)
        holder.onBind(userExercise)

    }

    override fun getItemCount(): Int {
        return activityList.size
    }
}