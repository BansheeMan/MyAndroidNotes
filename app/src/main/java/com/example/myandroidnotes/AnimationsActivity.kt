package com.example.myandroidnotes

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    var isOpen: Boolean = false
    private lateinit var binding: ActivityAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val transitionFade = Fade()
            transitionFade.duration = 3000
            val transitionChangeBounds = ChangeBounds()
            transitionChangeBounds.duration = 1000
            val transitionSlide = Slide(Gravity.BOTTOM)
            transitionSlide.duration = 4000

            val transitionSet = TransitionSet().run {
                // addTransition(transitionFade)
                addTransition(transitionChangeBounds)
                addTransition(transitionSlide)
            }
            TransitionManager.beginDelayedTransition(binding.transitionsContainer, transitionSet)

            isOpen = !isOpen
            binding.text.visibility = if (isOpen) {
                View.VISIBLE
            } else {
                View.GONE
            }

        }

    }
}