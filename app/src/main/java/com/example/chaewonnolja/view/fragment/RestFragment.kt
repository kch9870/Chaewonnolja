package com.example.chaewonnolja.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.repository.model.getData
import com.example.chaewonnolja.view.adaptor.HighRestViewAdapter
import com.example.chaewonnolja.view.item.HighRestItem
import com.example.chaewonnolja.view.item.RestItem
import kotlinx.android.synthetic.main.fragment_rest.*

class RestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_rest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         var data: List<getData>

    }

    fun initRecycler(data: List<getData>) {
        Log.d("Rinit",data.toString())
        //for문 처리 어떻게 해야될지 고민... 함수로 빼보자
        var itemList: MutableList<HighRestItem>


        itemList = mutableListOf(
            HighRestItem("서울시", mutableListOf(
                RestItem(data.get(0).firstimage.toString(),data.get(0).title.toString()),
                RestItem(data.get(1).firstimage.toString(),data.get(1).title.toString()),
                RestItem(data.get(2).firstimage.toString(),data.get(2).title.toString()),
                RestItem(data.get(3).firstimage.toString(),data.get(3).title.toString()),
                RestItem(data.get(4).firstimage.toString(),data.get(4).title.toString()),
                RestItem(data.get(5).firstimage.toString(),data.get(5).title.toString()),
            )
            ),
            HighRestItem("서울시", mutableListOf(
                RestItem(data.get(0).firstimage.toString(),data.get(0).title.toString()),
                RestItem(data.get(1).firstimage.toString(),data.get(1).title.toString()),
                RestItem(data.get(2).firstimage.toString(),data.get(2).title.toString()),
                RestItem(data.get(3).firstimage.toString(),data.get(3).title.toString()),
                RestItem(data.get(4).firstimage.toString(),data.get(4).title.toString()),
                RestItem(data.get(5).firstimage.toString(),data.get(5).title.toString()),
            )
            ),
            HighRestItem("서울시", mutableListOf(
                RestItem(data.get(0).firstimage.toString(),data.get(0).title.toString()),
                RestItem(data.get(1).firstimage.toString(),data.get(1).title.toString()),
                RestItem(data.get(2).firstimage.toString(),data.get(2).title.toString()),
                RestItem(data.get(3).firstimage.toString(),data.get(3).title.toString()),
                RestItem(data.get(4).firstimage.toString(),data.get(4).title.toString()),
                RestItem(data.get(5).firstimage.toString(),data.get(5).title.toString()),
            )
            ),
            HighRestItem("서울시", mutableListOf(
                RestItem(data.get(0).firstimage.toString(),data.get(0).title.toString()),
                RestItem(data.get(1).firstimage.toString(),data.get(1).title.toString()),
                RestItem(data.get(2).firstimage.toString(),data.get(2).title.toString()),
                RestItem(data.get(3).firstimage.toString(),data.get(3).title.toString()),
                RestItem(data.get(4).firstimage.toString(),data.get(4).title.toString()),
                RestItem(data.get(5).firstimage.toString(),data.get(5).title.toString()),
            )
            ),
            HighRestItem("서울시", mutableListOf(
                RestItem(data.get(0).firstimage.toString(),data.get(0).title.toString()),
                RestItem(data.get(1).firstimage.toString(),data.get(1).title.toString()),
                RestItem(data.get(2).firstimage.toString(),data.get(2).title.toString()),
                RestItem(data.get(3).firstimage.toString(),data.get(3).title.toString()),
                RestItem(data.get(4).firstimage.toString(),data.get(4).title.toString()),
                RestItem(data.get(5).firstimage.toString(),data.get(5).title.toString()),
            )
            )
        )
        restRecyclerView.adapter = HighRestViewAdapter(requireContext(), itemList)
        restRecyclerView.layoutManager = LinearLayoutManager(requireContext())

    }
}





