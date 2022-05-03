package com.example.finalproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.ui.ProfileFragment
import com.example.finalproject.SettingsFragment

class SettingsFragment : Fragment() {
    lateinit var binding : SettingsFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_settings, container, false)
        //    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        return rootView

    }

}