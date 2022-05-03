package com.example.finalproject.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.HomePageFragment
import com.example.finalproject.MedReminderFragment
import com.example.finalproject.R
import com.example.finalproject.SettingsFragment
import com.example.finalproject.data.ViewPagerData
import com.example.finalproject.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile,container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        sharedPrefs = requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        binding.apply {
//            tvHeight.text = "Height\n ${sharedPrefs.getString(getString(R.string.height_key),getString(R.string.height))}"
//            tvweight.text = "Weight\n ${sharedPrefs.getString(getString(R.string.weight_key),getString(R.string.weight))}"
            tvname.text = "Hi, ${sharedPrefs.getString(getString(R.string.name_key),"")}"
//            tvMedication.text = "${sharedPrefs.getString(getString(R.string.medication_key),"insulin")}\n ${sharedPrefs.getString(getString(R.string.medication_two_key),"")}"
//            tvtype.text = "${sharedPrefs.getString(getString(R.string.type1_key),"Type1")}\n ${sharedPrefs.getString(getString(R.string.type_2_key),"")}"
            //etTarget.setText(sharedPrefs.getString(getString(R.string.on_target_key),"0"))
       // etTarget.setText(ViewPagerData.yourActivities)

        }

        return binding.root

    }

}