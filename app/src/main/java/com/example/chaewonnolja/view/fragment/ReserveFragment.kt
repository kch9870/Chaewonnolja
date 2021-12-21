package com.example.chaewonnolja.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.view.activity.ReserveInfoActivity
import com.example.chaewonnolja.view.adaptor.RestViewAdapter
import com.example.chaewonnolja.view.item.RestItem
import kotlinx.android.synthetic.main.fragment_reserve.*

class ReserveFragment : Fragment() {

    val datas = mutableListOf<RestItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_reserve, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //initRecycler()
        Reserving()
    }
    private fun Reserving(){
        reserving.setOnClickListener {
            activity?.let{
                val intent = Intent(context, ReserveInfoActivity::class.java)
                startActivity(intent)
            }
        }
    }


//    private fun initRecycler() {
//        var restViewAdapter = activity?.let { RestViewAdapter(it) }!!
//        rv_lastRest.adapter = restViewAdapter
//
//        //데이터 값 넣어보기 대충
//        datas.apply {
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
//
//            restViewAdapter.datas = datas
//            restViewAdapter.notifyDataSetChanged()
//
//
//
//        }
//    }
}