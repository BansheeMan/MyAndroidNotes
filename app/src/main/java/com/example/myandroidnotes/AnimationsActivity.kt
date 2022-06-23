package com.example.myandroidnotes

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.*
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding
import com.example.myandroidnotes.databinding.ActivityAnimationsBonusStartBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration = 1000L
    private lateinit var binding: ActivityAnimationsBonusStartBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backgroundImage.setOnClickListener{

            val constraintSet = ConstraintSet()
            //constraintSet.clone(binding.constraintContainer)

            val transition = ChangeBounds()
            transition.interpolator = AnticipateOvershootInterpolator(5f)
            transition.duration = 1000
            TransitionManager.beginDelayedTransition(binding.constraintContainer,transition )

            isOpen = !isOpen
            if(isOpen) {
                constraintSet.clone(this, R.layout.activity_animations_bonus_end)
            } else {
                constraintSet.clone(this, R.layout.activity_animations_bonus_start)
            }
            constraintSet.applyTo(binding.constraintContainer)
        }
    }

}