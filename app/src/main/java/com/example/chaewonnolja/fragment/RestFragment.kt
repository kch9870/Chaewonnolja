package com.example.chaewonnolja.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.adaptor.RestViewAdapter
import com.example.chaewonnolja.item.RestItem
import kotlinx.android.synthetic.main.fragment_rest.*

class RestFragment : Fragment() {
    lateinit var restViewAdapter: RestViewAdapter
    val datas = mutableListOf<RestItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_rest, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //RecyclerView 불러오기
/*
    fun initRecycler() {
        restViewAdapter = RestViewAdapter(this)
        rv_rest.adapter = restViewAdapter


        datas.apply {
            add(RestItem(restImage = R.drawable.rest, restName = "mary", restCategory = "호텔"))

            restViewAdapter.datas = datas
            restViewAdapter.notifyDataSetChanged()

        }
    }*/
}