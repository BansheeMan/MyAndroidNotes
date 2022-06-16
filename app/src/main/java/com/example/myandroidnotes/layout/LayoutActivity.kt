package com.example.myandroidnotes.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myandroidnotes.R
import com.example.myandroidnotes.databinding.ActivityLayoutBinding
import com.gb.m_1919_1872_1.view.layout.fragments.ConstraintFragment
import com.gb.m_1919_1872_1.view.layout.fragments.CoordinatorFragment
import com.gb.m_1919_1872_1.view.layout.fragments.MotionFragment

class LayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_bottom_navigation_constraint -> {
                    navigationTo(ConstraintFragment())
                    true
                }
                R.id.action_bottom_navigation_constraint -> {
                    navigationTo(CoordinatorFragment())
                    true
                }
                R.id.action_bottom_navigation_motion -> {
                    navigationTo(MotionFragment())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_navigation_constraint
    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, f).commit()
    }


}