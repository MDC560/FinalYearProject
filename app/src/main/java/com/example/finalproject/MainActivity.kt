package com.example.finalproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finalproject.ui.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,HomePageFragment(),"Home").commit()
        bottomNav.setOnItemSelectedListener(object: NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                var fragment=
                    when(item.itemId)
                    {

                        R.id.menu_settings->{
                            SettingsFragment()

                        }
                        R.id.menu_account->
                        {
                            ProfileFragment()
                        }
                        R.id.menu_reminder->{
                            MedReminderFragment()
                        }
                        else->{
                            HomePageFragment()
                        }
                    }
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
                return true
            }
        })
    }

}