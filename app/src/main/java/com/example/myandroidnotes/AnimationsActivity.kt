package com.example.myandroidnotes

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationsBinding
    var isOpen: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {
            isOpen = !isOpen
            ////////////////////////////////////////////////////////////////
            val trCB = ChangeBounds()
            val trImage = ChangeImageTransform()
            trCB.duration = 3000
            trImage.duration = 3000
            val trSet = TransitionSet().apply {
               addTransition(trCB)    //ScaleType
               addTransition(trImage)  //изменение размеров в лэйауте (меняется height)
            }

            TransitionManager.beginDelayedTransition(binding.root, trSet)
            //////////////////////////////////////////////////////////////
            binding.imageView.scaleType = if (isOpen) {
                ImageView.ScaleType.CENTER_CROP
            } else {
                ImageView.ScaleType.CENTER_INSIDE
            }

            val params = (binding.imageView.layoutParams as FrameLayout.LayoutParams)
            params.height = if (isOpen) {
                FrameLayout.LayoutParams.MATCH_PARENT
            } else {
                FrameLayout.LayoutParams.WRAP_CONTENT
            }
            binding.imageView.layoutParams = params
        }

    }

}