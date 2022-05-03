package com.example.finalproject.ui.calories

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.data.local.model.UserFoodItem
import com.example.finalproject.databinding.FragmentCaloriesBinding
import java.util.*


class FoodItemFragment : Fragment() {

    lateinit var binding: FragmentCaloriesBinding
    lateinit var fooditemViewModel: FoodItemViewModel

    var num = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calories, container, false)
        fooditemViewModel = ViewModelProvider(this)[FoodItemViewModel::class.java]

        val date = Date().toString()

        binding.btnSubmit.setOnClickListener {


                //Converting value to integer
                val breakfast = getValueFromInputField(binding.etBreakfast)
                val lunch = getValueFromInputField(binding.etLunch)
                val dinner = getValueFromInputField(binding.etDinner)
                val snack = getValueFromInputField(binding.etSnack)
                val snack2 = getValueFromInputField(binding.etSnack2)
                val snack3 = getValueFromInputField(binding.etSnack3)
                val sum = breakfast + lunch + dinner + snack + snack2 + snack3
                binding.tvTotalCals.text = sum.toString()
                val breakfastCalories = UserFoodItem(name = "breakfast", date = date, totalCals = breakfast )
                val snackCalories = UserFoodItem(name = "snack", date = date, totalCals = snack )
                val lunchCalories = UserFoodItem(name = "Lunch", date = date, totalCals = lunch )
                val snackCalories2 = UserFoodItem(name = "Snack2", date = date, totalCals = snack2 )
                val dinnerCalories = UserFoodItem(name = "Dinner", date = date, totalCals = dinner )
                val dessertCalories2 = UserFoodItem(name = "Dessert", date = date, totalCals = snack3 )

                val foodItems = listOf<UserFoodItem>(breakfastCalories,snackCalories,lunchCalories,snackCalories2,dinnerCalories,dessertCalories2)
                    //Launch and save

                fooditemViewModel.insertData(requireContext(),foodItems)



        }

        return binding.root

    }

    fun getValueFromInputField(inputField:EditText):Int{
        return if(TextUtils.isEmpty(inputField.text)){
            0
        }
        else{
            inputField.text.toString().toInt()
        }
    }
}