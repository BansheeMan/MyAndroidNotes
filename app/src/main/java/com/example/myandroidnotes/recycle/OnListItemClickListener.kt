package com.example.myandroidnotes.recycle

interface OnListItemClickListener {

    fun onItemClick(data: Data)
    fun onAddBtnClick(position: Int)
    fun onRemoveBtnClick(position: Int)
    fun onMoveBtnClick(oldPosition: Int, newPosition: Int)
}