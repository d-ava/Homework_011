package com.example.homework_011

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_011.databinding.ItemBinding

typealias OnImageClick = (item: ItemData) -> Unit

class ItemsAdapter() :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {


    // var onImageClick:OnImageClick? = null
    lateinit var onImageClick: OnImageClick

    private var list = mutableListOf<ItemData>()

    fun setData(itemList: MutableList<ItemData>) {
        this.list.clear()
        this.list.addAll(itemList)
        notifyDataSetChanged()


    }


    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {


        private lateinit var item: ItemData

        fun onBind() {
            binding.root.setOnClickListener(this)
            item = list[adapterPosition]
            binding.ivImage.setImageResource(item.image)

        }

        override fun onClick(v: View?) {
            onImageClick.invoke(list[adapterPosition])
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