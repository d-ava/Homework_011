package com.example.homework_011

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_011.databinding.ItemScreenBinding

class ItemFragment:Fragment() {

    lateinit var binding: ItemScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemScreenBinding.inflate(inflater, container, false)




        return binding.root
    }
}


