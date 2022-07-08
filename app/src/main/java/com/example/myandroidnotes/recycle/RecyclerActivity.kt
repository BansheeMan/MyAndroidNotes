package com.example.myandroidnotes.recycle

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidnotes.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity(), OnListItemClickListener {


    lateinit var binding: ActivityRecyclerBinding
    lateinit var adapter: RecyclerActivityAdapter

    private val list = arrayListOf(
        Data("HEADER", "", TYPE_HEADER),
        Data("Earth1", "Earth des", TYPE_EARTH),
        Data("Earth2", "Earth des", TYPE_EARTH),
        Data("Mars3", "Mars des", TYPE_MARS),
        Data("Earth4", "Earth des", TYPE_EARTH),
        Data("Earth5", "Earth des", TYPE_EARTH),
        Data("Earth6", "Earth des", TYPE_EARTH),
        Data("Mars7", "Mars des", TYPE_MARS),
        Data("Mars8", "Mars des", TYPE_MARS),
        Data("Earth9", "Earth des", TYPE_EARTH),
        Data("Mars10", "Mars des", TYPE_MARS),
        Data("Mars11", "Mars des", TYPE_MARS)
    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerActivityAdapter(this)
        adapter.setList(list)
        binding.recyclerView.adapter = adapter

        binding.recyclerActivityFAB.setOnClickListener {
            onAddBtnClick(1)
        }
    }

    override fun onItemClick(data: Data) {

    }

    override fun onAddBtnClick(position: Int) {
        list.add(position, Data("Mars", "Mars New", TYPE_MARS))
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