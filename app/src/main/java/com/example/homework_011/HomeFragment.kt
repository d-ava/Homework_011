package com.example.homework_011

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.homework_011.databinding.HomeScreenBinding

typealias image = R.mipmap

class HomeFragment : Fragment() {

    private val adapter = ItemsAdapter()
    private val layoutManager = GridLayoutManager(context, 3)


    //private lateinit var binding: HomeScreenBinding
    private var binding:HomeScreenBinding? = null

    private lateinit var search: EditText  //for search edittext

    private val itemList = mutableListOf<ItemData>(
        ItemData(image.dog1, "Dog 1", "cute dog"),
        ItemData(image.fox1, "fox 1", "cute fox"),
        ItemData(image.dog2, "dog", "doggo"),
        ItemData(image.leopard1, "leopard", "nice leopard"),
        ItemData(image.lion1, "Lion", "king"),
        ItemData(image.waltz1, "Waltz", "inglorious basterds"),
        ItemData(image.lion2, "Lion", "king, lion king"),
        ItemData(image.waltz2, "Christof Waltz", "inglorious basterds"),
        ItemData(image.squirrel, "squirrel", "better than rat?")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeScreenBinding.inflate(inflater, container, false)

        adapter.setData(itemList)
        binding!!.recyclerView.adapter = adapter
        binding!!.recyclerView.layoutManager = layoutManager

        adapter.onImageClick={

        }

        //
        fun filterText(text: String) {
            val filteredTitleList = mutableListOf<ItemData>()

            for (item in itemList) {
                if (item.title.lowercase().contains(text.lowercase())) {
                    filteredTitleList.add(item)
                }
            }
            adapter.filteredList(filteredTitleList)
        }

        //

        search = binding!!.etSearch

        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filterText(s.toString())
            }

        })

        //

adapter.onImageClick = {
    val action = HomeFragmentDirections.actionToItemFragment(it)
    findNavController().navigate(action)
}



//


        return binding!!.root

    }




    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}