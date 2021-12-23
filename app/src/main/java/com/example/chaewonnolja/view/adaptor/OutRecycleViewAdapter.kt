package com.example.chaewonnolja.view.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chaewonnolja.databinding.ItemOutRecyclerViewBinding
import com.example.chaewonnolja.view.item.HighRestItem
import com.example.chaewonnolja.view.item.RestItem

class OutRecyclerViewAdapter(val context: Context, val itemList: MutableList<HighRestItem>): RecyclerView.Adapter<OutRecyclerViewAdapter.Holder>() {

    var datas = mutableListOf<HighRestItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemOutRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val outItem = itemList[position]
        holder.bind(outItem)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: ItemOutRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HighRestItem) {
            item.region=binding.regionTitle.toString()

            binding.innerRecyclerview.adapter = RestViewAdapter(context, item.innerList)
            binding.innerRecyclerview.layoutManager = LinearLayoutManager(context)
        }
    }

}