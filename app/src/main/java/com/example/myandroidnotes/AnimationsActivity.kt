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

        binding.fab.setOnClickListener {
            isOpen = !isOpen
            ////////////////////////////////////////////////////////////////
            if (isOpen) {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, 0f, 135f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, 0f, -135f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, 0f, -250f)
                    .setDuration(duration).start()

                binding.optionTwoContainer.animate().alpha(1f).setDuration(duration).setListener(object :AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        binding.optionTwoContainer.isClickable = true
                    }
                })

                binding.optionOneContainer.animate().alpha(1f).setDuration(duration).setListener(object :AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                       binding.optionOneContainer.isClickable = true
                        Log.d("@@@", "${binding.optionOneContainer.isClickable}")

                    }
                })

                binding.transparentBackground.animate().alpha(0.6f).duration = duration

            } else {
                ObjectAnimator.ofFloat(binding.plusImageview, View.ROTATION, 135f, 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionOneContainer, View.TRANSLATION_Y, -135f, 0f)
                    .setDuration(duration).start()
                ObjectAnimator.ofFloat(binding.optionTwoContainer, View.TRANSLATION_Y, -250f, 0f)
                    .setDuration(duration).start()

                binding.optionTwoContainer.animate().alpha(0f).setDuration(duration).setListener(object :AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        binding.optionTwoContainer.isClickable = false
                    }
                })

                binding.optionOneContainer.animate().alpha(0f).setDuration(duration).setListener(object :AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        binding.optionOneContainer.isClickable = false
                        Log.d("@@@", "${binding.optionOneContainer.isClickable}")

                    }
                })

                binding.transparentBackground.animate().alpha(0.0f).duration = duration
            }
        }


        binding.optionOneContainer.setOnClickListener { //когда вешаем слушатель isClickable = true
            Toast.makeText(this, "optionOneContainer", Toast.LENGTH_SHORT).show()

        }
        binding.optionOneContainer.isClickable = false
        Log.d("@@@", "${binding.optionOneContainer.isClickable}")

    }

}