package com.example.batikapp.ui.history.kain.kain5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.batikapp.databinding.FragmentKain5Binding


class Kain5Fragment : Fragment() {

    private lateinit var binding: FragmentKain5Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKain5Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
}