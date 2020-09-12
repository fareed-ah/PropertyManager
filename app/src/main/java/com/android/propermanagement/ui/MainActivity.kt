package com.android.propermanagement.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.android.propermanagement.R
import com.android.propermanagement.ui.expenses.ExpensesFragment
import com.android.propermanagement.ui.payments.PaymentsFragment
import com.android.propermanagement.ui.properties.PropertyListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNav()
        changeFragment(PropertyListFragment())
    }

    private fun setupBottomNav() {
        bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.home -> changeFragment(PropertyListFragment())
                R.id.expenses -> changeFragment(ExpensesFragment())
                R.id.payments -> {
                    changeFragment(PaymentsFragment())
                }
                R.id.settings -> {
                }
            }
            true
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun changeFragment(newFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        while (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate()
        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, newFragment)
        fragmentTransaction.commit()
    }
}