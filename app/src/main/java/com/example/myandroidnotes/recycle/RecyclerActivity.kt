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
            Data("HEADER","", TYPE_HEADER),
            Data("Earth1","Earth des",TYPE_EARTH),
            Data("Earth2","Earth des",TYPE_EARTH),
            Data("Mars3", "Mars des",TYPE_MARS),
            Data("Earth4","Earth des",TYPE_EARTH),
            Data("Earth5","Earth des",TYPE_EARTH),
            Data("Earth6","Earth des",TYPE_EARTH),
            Data("Mars7", "Mars des",TYPE_MARS),
            Data("Mars8", "Mars des",TYPE_MARS),
            Data("Earth9","Earth des",TYPE_EARTH),
            Data("Mars10", "Mars des",TYPE_MARS),
            Data("Mars11", "Mars des",TYPE_MARS)


        )

        binding.recyclerView.adapter = RecyclerActivityAdapter(list)
    }
}