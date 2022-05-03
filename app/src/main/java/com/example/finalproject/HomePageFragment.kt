package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.callback.DialogCallBack
import com.example.finalproject.databinding.FragmentHomePageBinding
import com.example.finalproject.ui.activities.ExerciseFragment
import com.example.finalproject.ui.glucose.BloodGlucoseFragment
import com.example.finalproject.ui.medicine.MedicineCountFragment

class HomePageFragment : Fragment(), DialogCallBack{

    lateinit var binding: FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false)
        val rootView = binding.root
        requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)


        binding.medTitle.setOnClickListener {

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, MedicineCountFragment())
                .addToBackStack(null)
                .commit()

        }
        binding.activityTitle.setOnClickListener {

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ExerciseFragment())
                .addToBackStack(null)
                .commit()

        }

        binding.tvBgTitle.setOnClickListener {

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, BloodGlucoseFragment())
                .addToBackStack(null)
                .commit()

        }

        binding.tvCalsTitle.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, CaloriesFragment())
                .addToBackStack(null)
                .commit()

        }


        return binding.root

    }
    val TAG="Dialog Click"

    override fun onPositiveButonClick() {
        Log.d(TAG, "onPositiveButonClick: ")
    }

    override fun onNegtiveButtonClick() {
        Log.d(TAG, "onNegtiveButtonClick: ")
    }

}
