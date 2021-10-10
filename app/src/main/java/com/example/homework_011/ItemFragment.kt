package com.example.homework_011

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.homework_011.databinding.ItemScreenBinding

class ItemFragment : Fragment() {

    lateinit var binding: ItemScreenBinding

    private val args: ItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemScreenBinding.inflate(inflater, container, false)


        binding.tvBack.setOnClickListener {
            findNavController().navigate(R.id.actionToHomeFragment)
        }


        binding.tvTiTle.text = args.item.title
        binding.tvDescription.text = args.item.description
        binding.ivImage.setImageResource(args.item.image)

        return binding.root
    }
}


