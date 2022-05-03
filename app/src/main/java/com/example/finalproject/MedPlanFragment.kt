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
import com.example.finalproject.databinding.FragmentMedPlanBinding


class MedPlanFragment : Fragment() {
    lateinit var binding: FragmentMedPlanBinding

    lateinit var sharedPrefs: SharedPreferences
    var metformin = false
    var insulin = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_med_plan,container,false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_med_plan, container, false)
        sharedPrefs = requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        binding.btnInsulin.setOnClickListener {
            if (insulin) {
                binding.btnInsulin.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.white)
            } else {
                binding.btnInsulin.backgroundTintList =
                    ContextCompat.getColorStateList(requireActivity(), R.color.colorPrimary)
            }
            insulin = !insulin
        }

        binding.btnMetformin.setOnClickListener {
            if (metformin) {
                binding.btnMetformin.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.white)
            } else {
                binding.btnMetformin.backgroundTintList = ContextCompat.getColorStateList(requireActivity(), R.color.colorPrimary)
            }
            metformin = !metformin
        }
        binding.btnGo.setOnClickListener {
            val metforminStock = binding.etMetforminStock.text.toString()
            val insulinStock = binding.etInsulinStock.text.toString()
            val dailyDose = binding.TvDosage.text.toString()
            if (insulin || metformin) {
                with(sharedPrefs.edit()) {
                    if (insulin) {
                        putString(getString(R.string.medication_key), getString(R.string.insulin)).apply()
                        }
                    else {
                        putString(getString(R.string.medication_key), "").apply()
                    }
                    if (metformin)
                        putString(
                            getString(R.string.medication_two_key),
                            getString(R.string.metformin)
                        ).apply()
                    else {
                        putString(getString(R.string.medication_two_key), "").apply()
                    }
                    putInt(getString(R.string.insulin_key), insulinStock.toInt()).apply()
                    putInt(getString(R.string.metforminstock_key), metforminStock.toInt()).apply()
                    putInt(getString(R.string.daily_dosage), dailyDose.toInt()).apply()

                }
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentcontainer_view_signup, TermsConditionsFragment())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireActivity(), "Enter a valid medication!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        binding.btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }


        return binding.root

    }

}