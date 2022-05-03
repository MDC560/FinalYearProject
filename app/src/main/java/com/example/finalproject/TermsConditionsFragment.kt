package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.HomePageFragment
import com.example.finalproject.R
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.databinding.FragmentTermsConditionsBinding

class TermsConditionsFragment : Fragment() {
    lateinit var binding: FragmentTermsConditionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?):
            View? {
        SharedPreferenceHelper.getSharedPreference(requireContext())
        val rootView = inflater.inflate(R.layout.fragment_terms_conditions, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_terms_conditions, container, false)

        binding.btnGo.setOnClickListener {
            val mainActivity = Intent(requireActivity(),SignUpActivity::class.java)
            startActivity(mainActivity)
            SharedPreferenceHelper.IS_SIGN_UP(true)
        }

        return binding.root
    }


}