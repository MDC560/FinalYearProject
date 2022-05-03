package com.example.finalproject

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.MedPlanFragment
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentTypeBinding


class TypeFragment : Fragment() {
    lateinit var binding : FragmentTypeBinding
    lateinit var sharedPref : SharedPreferences
    var type1 = false
    var type2 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_type, container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_type, container, false)
        sharedPref = requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )

        binding.btnType1.setOnClickListener { //changing color on click
            if (type1) {
                binding.btnType1.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.white)
            } else {
                binding.btnType1.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.colorPrimary)
            }
            type1 = !type1
        }

        binding.btnType2.setOnClickListener {
            if (type2) {
                binding.btnType2.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.white)
            } else {
                binding.btnType2.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.colorPrimary)
            }
            type2 = !type2
        }

        binding.btnContinue.setOnClickListener {
            if (type1 || type2) {
                with(sharedPref.edit()) {
                    if (type1)
                        putString(getString(R.string.type1_key), "Type1")
                    else
                        putString(getString(R.string.type1_key), "")
                    if (type2)
                        putString(getString(R.string.type_2_key), "Type2")
                    else
                        putString(getString(R.string.type_2_key), "")
                    apply()
                }
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentcontainer_view_signup, MedPlanFragment())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireActivity(), "Please choose a type.", Toast.LENGTH_LONG).show()
            }

        }


        return binding.root
    }

}