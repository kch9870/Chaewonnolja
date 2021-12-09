package com.example.chaewonnolja.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chaewonnolja.R
import com.example.chaewonnolja.item.RestItem

class RestViewAdapter(val context: Context, private val RestItemList: ArrayList<RestItem>) {

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!){

        val restImage= view?.findViewById<ImageView>(R.id.restImage)
        val restName= view?.findViewById<TextView>(R.id.restName)
        val restCategory= view?.findViewById<TextView>(R.id.restCategory)

        //바인딩 할 곳
        fun bind(rest: RestItem, context: Context){
            restImage.setImageDrawable()    //image소스
            restName?.text=rest.restName
            restCategory?.text=rest.restCategory
        }

        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_rest_view, parent, false)
            //바인딩 당할 Item XML 파일명 지정 --R.layout.item_rest_view
            return ViewHolder(view)
        }
        fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //데이터를 순서대로 바인딩 --포지션(인덱스)값을 활용 가능. 현재는 모든 값 바인딩
            holder.bind(RestItemList[position], context)
        }

    }
}