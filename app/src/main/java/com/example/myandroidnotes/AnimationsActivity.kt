package com.example.myandroidnotes

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.example.myandroidnotes.databinding.ActivityAnimationsKirillBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration = 1000L
    private lateinit var binding: ActivityAnimationsKirillBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsKirillBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val constraintSetStart = ConstraintSet()
        val constraintSetEnd = ConstraintSet()
        constraintSetStart.clone(this,R.layout.include_fab_animations_start)
        constraintSetEnd.clone(this, R.layout.include_fab_animations_end)

        binding.anim.fabCenter.setOnClickListener {

            val transitionSet = TransitionSet()
            val transitionCB = ChangeBounds()
            val transitionFade = Fade()
            transitionSet.addTransition(transitionCB)
            transitionSet.addTransition(transitionFade)
            transitionSet.interpolator = AnticipateOvershootInterpolator(5f)
            transitionSet.duration = 1000
            TransitionManager.beginDelayedTransition(binding.anim.container,transitionSet )

            isOpen = !isOpen
            if(!isOpen){
                constraintSetStart.applyTo(binding.anim.container)
            }else{
                constraintSetEnd.applyTo(binding.anim.container)
            }
        }
    }

}