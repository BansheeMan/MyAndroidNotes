package com.example.myandroidnotes

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.example.myandroidnotes.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = Adapter()
    }

    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
            return mViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_animations_recycler_item,
                    parent,
                    false
                ) as View
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.setOnClickListener { button ->
                val epicenter = Rect()
                button.getGlobalVisibleRect(epicenter)
                val transitionExplode = Explode()
                transitionExplode.epicenterCallback = object: Transition.EpicenterCallback() {
                    override fun onGetEpicenter(transition: Transition): Rect {
                        return epicenter
                    }
                }
                transitionExplode.duration = 3000

                transitionExplode.excludeTarget(button,true) // исключает цель (нажатую кнопку)

                val transitionFade = Fade().addTarget(button) // выбираем цель для затемнения
                transitionFade.duration = 5000
                val transitionSet = TransitionSet().apply {
                    addTransition(transitionExplode)
                    addTransition(transitionFade)
                }

                TransitionManager.beginDelayedTransition(binding.recyclerView, transitionSet)
                binding.recyclerView.adapter = null
            }
        }

        override fun getItemCount(): Int {
            return 28
        }

    }

    inner class mViewHolder(view: View) : RecyclerView.ViewHolder(view)

}