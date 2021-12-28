package com.example.chaewonnolja.view.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chaewonnolja.databinding.ItemHighRecyclerviewBinding
import com.example.chaewonnolja.view.item.HighRestItem

class HighRestViewAdapter(val context: Context, val itemList: MutableList<HighRestItem>): RecyclerView.Adapter<HighRestViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemHighRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: ItemHighRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HighRestItem) {
            binding.model = item

            binding.innerRecyclerview.adapter = RestViewAdapter(context,item.rList)
            binding.innerRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

}