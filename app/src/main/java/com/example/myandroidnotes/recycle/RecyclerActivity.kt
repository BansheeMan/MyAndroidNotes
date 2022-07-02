package com.example.myandroidnotes.recycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidnotes.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {


    lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val list = arrayListOf(
            Data("Earth","Earth des",TYPE_EARTH),
            Data("Earth","Earth des",TYPE_EARTH),
            Data("Mars", "Mars des",TYPE_MARS),
            Data("Earth","Earth des",TYPE_EARTH),
            Data("Earth","Earth des",TYPE_EARTH),
            Data("Earth","Earth des",TYPE_EARTH),
            Data("Mars", "Mars des",TYPE_MARS)
        )

        binding.recyclerView.adapter = RecyclerActivityAdapter(list)
    }
}