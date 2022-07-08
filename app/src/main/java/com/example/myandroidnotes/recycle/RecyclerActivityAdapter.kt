package com.example.myandroidnotes.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidnotes.databinding.ActivityRecyclerItemEarthBinding
import com.example.myandroidnotes.databinding.ActivityRecyclerItemHeaderBinding
import com.example.myandroidnotes.databinding.ActivityRecyclerItemMarsBinding

const val TYPE_EARTH = 1
const val TYPE_MARS = 2
const val TYPE_HEADER = 3

class RecyclerActivityAdapter(private var onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var list: List<Data>

    fun setList(newList: List<Data>) {
        this.list = newList
    }

    fun setAddToList(newList: List<Data>, position: Int) {
        this.list = newList
        notifyItemChanged(position)
    }

    fun setRemoveToList(newList: List<Data>, position: Int) {
        this.list = newList
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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
            TYPE_HEADER -> {
                val view =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(view.root)
            }
            else -> {
                val view =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(view.root)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.myBind(list[position])
    }

    inner class MarsViewHolder(view: View) : BaseViewHolder(view) {
        override fun myBind(data: Data) {
            (ActivityRecyclerItemMarsBinding.bind(itemView)).apply {
                title.text = data.someText
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition)
                }
                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveBtnClick(layoutPosition)
                }
            }
        }
    }
}

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun myBind(data: Data)
}

class HeaderViewHolder(view: View) : BaseViewHolder(view) {
    override fun myBind(data: Data) {
        (ActivityRecyclerItemHeaderBinding.bind(itemView)).apply {
            header.text = data.someText
        }
    }
}

class EarthViewHolder(view: View) : BaseViewHolder(view) {
    override fun myBind(data: Data) {

        /*(itemView as ConstraintLayout).findViewById<TextView>(R.id.title).text = data.someText
            (itemView as ConstraintLayout).findViewById<TextView>(R.id.descriptionTextView).text = data.someDescription*/

        /*val binding = ActivityRecyclerItemEarthBinding.bind(itemView)
        binding.title.text =data.someText
        binding.descriptionTextView.text = data.someDescription*/

        (ActivityRecyclerItemEarthBinding.bind(itemView)).apply {
            title.text = data.someText
            descriptionTextView.text = data.someDescription
        }
    }
}

