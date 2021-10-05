package com.idn.adeeva.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.idn.adeeva.R
import com.idn.adeeva.databinding.ActivityMainBinding
import com.idn.adeeva.fragment.BreakfastFragment
import com.idn.adeeva.fragment.DessertFragment
import com.idn.adeeva.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.breakfast_menu -> setCurrentFragment(BreakfastFragment())
                R.id.vegetarian_menu -> setCurrentFragment(VegetarianFragment())
                R.id.dessert_menu -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain, fragment)
            commit()
        }
    }
}