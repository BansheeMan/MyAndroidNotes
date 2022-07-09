package com.example.myandroidnotes.recycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.myandroidnotes.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), OnListItemClickListener {


    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: RecyclerActivityAdapter

    private val list = arrayListOf(
        Pair(Data("HEADER", "", TYPE_HEADER), false),
        Pair(Data("Earth1", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth2", "Earth des", TYPE_EARTH), false),
        Pair(Data("Mars3", "Mars des", TYPE_MARS), false),
        Pair(Data("Earth4", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth5", "Earth des", TYPE_EARTH), false),
        Pair(Data("Earth6", "Earth des", TYPE_EARTH), false),
        Pair(Data("Mars7", "Mars des", TYPE_MARS), false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lon = 1
        val lat = 2
        val temp = 20
        val loc = Pair(lon, lat)
        val loc2 = lon to lat
        loc2.first
        loc.first
        loc.second
        val weather = Triple(lon, lat, temp)
        weather.third
        val weather2 = lon to lat to temp
        weather2.second

        adapter = RecyclerActivityAdapter(this)
        adapter.setList(list)
        binding.recyclerView.adapter = adapter

        binding.recyclerActivityFAB.setOnClickListener {
            onAddBtnClick(1)
        }

        ItemTouchHelper(ItemTouchHelperCallback(adapter)).attachToRecyclerView(binding.recyclerView)
    }

    override fun onItemClick(data: Data) {

    }

    override fun onAddBtnClick(position: Int) {
        list.add(position, Pair(Data("Mars", "Mars New", TYPE_MARS), false))
        adapter.setAddToList(list, position)
    }

    override fun onRemoveBtnClick(position: Int) {
        list.removeAt(position)
        adapter.setRemoveToList(list, position)
    }

    override fun onMoveBtnClick(oldPosition: Int, newPosition: Int) {
        try {
            if (newPosition != 0) {
                list.removeAt(oldPosition).apply {
                    list.add(newPosition, this)
                }
                adapter.moveItemToList(list, oldPosition, newPosition)
            }
        } catch (e: IndexOutOfBoundsException) {
            Toast.makeText(this, "Вы пытаетесь выйти за рамки массива", Toast.LENGTH_SHORT).show()
        }
    }


}