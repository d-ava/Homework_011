package com.example.homework_011

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_011.databinding.ItemBinding

class ItemsAdapter() :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private var list = mutableListOf<ItemData>()

    fun setData(itemList: MutableList<ItemData>) {
        this.list.clear()
        this.list.addAll(itemList)
        notifyDataSetChanged()


    }


    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        private lateinit var item: ItemData
        fun onBind() {
            item = list[adapterPosition]
            binding.ivImage.setImageResource(item.image)

        }


    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemsAdapter.ItemViewHolder {
        return ItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }

    override fun onBindViewHolder(holder: ItemsAdapter.ItemViewHolder, position: Int) {

        holder.onBind()


    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun filteredList(flist: MutableList<ItemData>) {
        list = flist
        notifyDataSetChanged()
    }


}