package com.example.finalproject.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.data.local.model.UserExercise
import com.example.finalproject.ui.activities.ExerciseViewModel


class ChartFragment : Fragment() {


    lateinit var activityList:RecyclerView
    lateinit var exerciseViewModel: ChartViewModel

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
        exerciseViewModel = ViewModelProvider(requireActivity())[ChartViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_chart, container, false)
        activityList = view.findViewById(R.id.activites_list)
        activityList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        SharedPreferenceHelper.getSharedPreference(requireContext())

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userId = SharedPreferenceHelper.getUserId()
        exerciseViewModel.getListOfActivitiesByUserId(requireContext(),userId)
        exerciseViewModel.liveDataExercise.observe(viewLifecycleOwner, Observer {

            it?.let {
                val activityAdapter = ActivityAdapter(it)
                activityList.adapter= activityAdapter
            }

        })
    }


}