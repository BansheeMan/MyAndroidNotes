package com.example.myandroidnotes.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidnotes.databinding.ActivityRecyclerItemEarthBinding
import com.example.myandroidnotes.databinding.ActivityRecyclerItemMarsBinding

const val TYPE_EARTH = 1
const val TYPE_MARS = 2

class RecyclerActivityAdapter(private var list: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EARTH -> {
                val view =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(view.root)
            }
            TYPE_MARS -> {
                val view =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
            else -> {
                val view =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_EARTH -> {
                (holder as EarthViewHolder).myBind(list[position])
            }
            TYPE_MARS -> {
                (holder as MarsViewHolder).myBind(list[position])
            }
        }
    }
}


class EarthViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun myBind(data: Data) {

        /*(itemView as ConstraintLayout).findViewById<TextView>(R.id.title).text = data.someText
            (itemView as ConstraintLayout).findViewById<TextView>(R.id.descriptionTextView).text = data.someDescription*/

        /*val binding = ActivityRecyclerItemEarthBinding.bind(itemView)
        binding.title.text =data.someText
        binding.descriptionTextView.text = data.someDescription*/

        (ActivityRecyclerItemEarthBinding.bind(itemView)).apply {
            descriptionTextView.text = data.someDescription
        }
    }
}

class MarsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun myBind(data: Data) {
        (ActivityRecyclerItemMarsBinding.bind(itemView)).apply {
            title.text = data.someText
        }
    }
}