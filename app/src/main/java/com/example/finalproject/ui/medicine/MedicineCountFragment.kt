package com.example.finalproject.ui.medicine

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.data.local.SharedPreferenceHelper
import com.example.finalproject.data.local.model.UserMedicine
import com.example.finalproject.databinding.FragmentMedCounterBinding


class MedicineCountFragment : Fragment() {
    lateinit var binding: FragmentMedCounterBinding
    lateinit var medicineViewModel : MedicineViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        medicineViewModel = ViewModelProvider(this)[MedicineViewModel::class.java]
        val name = "Insulin"

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_med_counter, container, false)
        SharedPreferenceHelper.getSharedPreference(requireContext())
        binding.Insulinnum.setText(SharedPreferenceHelper.getInsulinStock().toString())
        binding.MetforminStockNumber.setText(SharedPreferenceHelper.getMetforminStock().toString())
        val insulinStockVal = binding.Insulinnum.toString()
        val metforminStockVal = binding.MetforminStock.text.toString()

        val medCount = UserMedicine(medicineName = name, insulinStock = 1 , MetforminStock = 2)
        medicineViewModel.insertData(requireContext(), medCount)


        binding.btnInsulinAddFive.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getInsulinStock()
            currentValue += 28
            SharedPreferenceHelper.saveInsulinStock(currentValue)
            binding.Insulinnum.text = currentValue.toString()
        }
        binding.BtnInsulinAdd.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getInsulinStock()
            currentValue += 1
            SharedPreferenceHelper.saveInsulinStock(currentValue)
            binding.Insulinnum.text = currentValue.toString()
        }


        binding.btnInsulinMinus.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getInsulinStock()
            if(currentValue<1)return@setOnClickListener
            currentValue -= 1 //cant decrease if val is less thn 1
            SharedPreferenceHelper.saveInsulinStock(currentValue)
            binding.Insulinnum.text = currentValue.toString()
        }

        binding.btnMetforminAdd.setOnClickListener{
            var currentValue = SharedPreferenceHelper.getMetforminStock()
            currentValue += 28
            SharedPreferenceHelper.saveMetforminStock(currentValue)
            binding.MetforminStockNumber.text = currentValue.toString()
        }
        binding.BtnMetforminAddOne.setOnClickListener{
            var currentValue = SharedPreferenceHelper.getMetforminStock()
            currentValue += 1
            SharedPreferenceHelper.saveMetforminStock(currentValue)
            binding.MetforminStockNumber.text = currentValue.toString()
        }
        binding.btnMetforminMinus.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getMetforminStock()
            if(currentValue<1)return@setOnClickListener
            currentValue -= 1
            SharedPreferenceHelper.saveMetforminStock(currentValue)
            binding.MetforminStockNumber.text = currentValue.toString()
        }
        binding.btnTestStripMinus.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getTestStripStock()
            if(currentValue<1)return@setOnClickListener //do nothing
            currentValue -=1
            SharedPreferenceHelper.saveInsulinStock(currentValue)
            binding.testStripNum.text = currentValue.toString()
        }
        binding.btnTestStripAddOne.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getTestStripStock()
            currentValue +=1
            SharedPreferenceHelper.saveTestStripStock(currentValue)
            binding.testStripNum.text = currentValue.toString()
        }
        binding.btnTestStrip.setOnClickListener {
            var currentValue = SharedPreferenceHelper.getTestStripStock()
            currentValue+=28
            SharedPreferenceHelper.saveTestStripStock(currentValue)
        }

        if(SharedPreferenceHelper.getMetforminStock()<5){
            binding.medicationTitle.text = "\nRefill reminder - Metformin"
            }
        if(SharedPreferenceHelper.getInsulinStock()<5){
            binding.medicationTitle.append("\nRefill reminder - Insulin")
        }
        if (SharedPreferenceHelper.getTestStripStock() < 5)
            binding.medicationTitle.append("\n Refill reminder - Test Strip.")

        return binding.root
    }

}