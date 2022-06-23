package com.example.myandroidnotes

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration = 1000L
    private lateinit var binding: ActivityAnimationsBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.header.isSelected = true
        //binding.header.isSelected = false

        binding.scrollView.setOnScrollChangeListener{ _,_,_,_,_ ->
            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }

    }

}