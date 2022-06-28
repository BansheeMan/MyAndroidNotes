package com.example.myandroidnotes

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.example.myandroidnotes.databinding.ActivityAnimationsBonusStartBinding

class AnimationsActivity : AppCompatActivity() {

    private val duration = 1000L
    private lateinit var binding: ActivityAnimationsBonusStartBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBonusStartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backgroundImage.setOnClickListener {

            val constraintSet = ConstraintSet()
            constraintSet.clone(binding.constraintContainer)

            val transition = ChangeBounds()
            transition.interpolator = AnticipateOvershootInterpolator(5f)
            transition.duration = 1000
            TransitionManager.beginDelayedTransition(binding.constraintContainer, transition)

            isOpen = !isOpen
            if (isOpen) {
                //constraintSet.clear(R.id.title)
                constraintSet.connect(
                    R.id.title,
                    ConstraintSet.RIGHT,
                    R.id.backgroundImage,
                    ConstraintSet.RIGHT
                )
            } else {
                constraintSet.connect(
                    R.id.title,
                    ConstraintSet.RIGHT,
                    R.id.backgroundImage,
                    ConstraintSet.LEFT
                )
            }
            constraintSet.applyTo(binding.constraintContainer)
        }
    }

}