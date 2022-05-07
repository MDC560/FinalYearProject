package com.example.finalproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.local.model.UserExercise


class ChartFragment : Fragment() {


    lateinit var activityList:RecyclerView
    val data = listOf<UserExercise>(
        UserExercise(0,1,10,"time","Moderate","Boxing"),
        UserExercise(0,1,10,"time","Moderate","Boxing"),
        UserExercise(0,1,10,"time","Moderate","Boxing"),
        UserExercise(0,1,10,"time","Moderate","Boxing")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chart, container, false)
        activityList = view.findViewById(R.id.activites_list)
        val activityAdapter = ActivityAdapter(data)
        activityList.adapter= activityAdapter

        return view
    }


}