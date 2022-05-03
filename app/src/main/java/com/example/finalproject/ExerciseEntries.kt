package com.example.finalproject;
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.finalproject.ui.activities.ExerciseFragment
import com.example.finalproject.databinding.FragmentExerciseEntriesBinding
import com.example.finalproject.ui.ProfileFragment


class ExerciseEntries : Fragment() {

    private lateinit var binding:FragmentExerciseEntriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentExerciseEntriesBinding.inflate(inflater,container,false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = PagerAdapter(this)

    }

    class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            // Return a NEW fragment instance in createFragment(int)
            return when (position) {
                0 -> ExerciseFragment()
                1 -> ProfileFragment()
                2 -> HomePageFragment()
                else -> ExerciseFragment()
            }
        }
    }
}