package com.gb.m_1919_1872_1.view.layout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myandroidnotes.databinding.ActivityLayoutBinding


class MotionFragment : Fragment() {


    private var _binding: ActivityLayoutBinding? = null
    private val binding: ActivityLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = MotionFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}