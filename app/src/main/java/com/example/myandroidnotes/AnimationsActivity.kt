package com.example.myandroidnotes

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.*
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationsBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            isOpen = !isOpen
            ////////////////////////////////////////////////////////////////
            val trCB = ChangeBounds()
            val path = ArcMotion()
            path.maximumAngle = 90.0f
            trCB.duration = 3000
            trCB.setPathMotion(path)
            val trSet = TransitionSet().apply {
               addTransition(trCB)
            }

            TransitionManager.beginDelayedTransition(binding.root, trSet)
            //////////////////////////////////////////////////////////////
            val params = (binding.button.layoutParams as FrameLayout.LayoutParams)
            params.gravity = if (isOpen) {
                Gravity.BOTTOM or Gravity.END
            } else {
                Gravity.TOP or Gravity.START
            }
            binding.button.layoutParams = params
        }

    }

}