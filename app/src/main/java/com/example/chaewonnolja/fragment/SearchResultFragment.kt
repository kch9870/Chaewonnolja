package com.example.chaewonnolja.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.chaewonnolja.R
import com.example.chaewonnolja.adaptor.RestViewAdapter
import com.example.chaewonnolja.adaptor.SearchResultAdapter
import com.example.chaewonnolja.item.RestItem
import kotlinx.android.synthetic.main.fragment_reserve.*
import kotlinx.android.synthetic.main.fragment_rest.*
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment: Fragment() {
    val datas = mutableListOf<RestItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }

    fun initRecycler() {
        var searchResultAdapter = activity?.let { SearchResultAdapter(it) }!!
        rv_searchResult.adapter = searchResultAdapter

        //데이터 값 넣어보기 대충
        datas.apply {
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))
            add(RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"))

            searchResultAdapter.datas = datas
            searchResultAdapter.notifyDataSetChanged()

        }
    }
}