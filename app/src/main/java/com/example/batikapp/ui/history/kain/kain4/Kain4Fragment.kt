package com.example.batikapp.ui.history.kain.kain4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.batikapp.databinding.FragmentKain4Binding


class Kain4Fragment : Fragment() {
    private lateinit var binding: FragmentKain4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKain4Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
}