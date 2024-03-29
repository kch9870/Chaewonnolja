package com.example.chaewonnolja.view.adaptor

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.chaewonnolja.databinding.ItemRestViewBinding
import com.example.chaewonnolja.view.item.RestItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.chaewonnolja.R

class RestViewAdapter(context: Context, val itemList: MutableList<RestItem>): RecyclerView.Adapter<RestViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemRestViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class Holder(var binding: ItemRestViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RestItem) {
            binding.model = item

            val image: ImageView = itemView.findViewById(R.id.restImage)
            val imageUrl = item.restImage

            Glide.with(itemView).load(imageUrl).into(image)

        }
    }
}