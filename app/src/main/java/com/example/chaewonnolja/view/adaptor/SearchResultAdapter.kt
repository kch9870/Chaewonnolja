package com.example.chaewonnolja.view.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chaewonnolja.R
import com.example.chaewonnolja.view.item.RestItem

class SearchResultAdapter(val context: Context) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    var datas = mutableListOf<RestItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search_result,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val restImage: ImageView = itemView.findViewById(R.id.restImage_searchResult)
        private val restCategory: TextView = itemView.findViewById(R.id.restCategory_searchResult)
        private val restName: TextView = itemView.findViewById(R.id.restName_searchResult)

        fun bind(item: RestItem) {
            restName.text = item.restName
            restCategory.text = item.restCategory

            //bulid.gradle 에 Glide 라이브러리 추가
            Glide.with(itemView).load(item.restImage).into(restImage)

            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }

        }

    }

    interface OnItemClickListener{
        fun onItemClick(v:View, data:RestItem , pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener:OnItemClickListener) {
        this.listener = listener
    }
}