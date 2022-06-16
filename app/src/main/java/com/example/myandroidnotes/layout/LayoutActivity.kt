package com.example.myandroidnotes.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myandroidnotes.R
import com.example.myandroidnotes.databinding.ActivityLayoutBinding
import com.example.myandroidnotes.layout.constraint.ConstraintFragment
import com.example.myandroidnotes.layout.coordinator.CoordinatorFragment
import com.example.myandroidnotes.layout.motion.MotionFragment

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
                    navigationTo(ConstraintFragment.newInstance())
                    true
                }
                R.id.action_bottom_navigation_coordinator -> {
                    navigationTo(CoordinatorFragment.newInstance())
                    true
                }
                R.id.action_bottom_navigation_motion -> {
                    navigationTo(MotionFragment.newInstance())
                    true
                }
                else -> true
            }
        }
        binding.bottomNavigationView.selectedItemId = R.id.action_bottom_navigation_coordinator
    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, f).commit()
    }
}