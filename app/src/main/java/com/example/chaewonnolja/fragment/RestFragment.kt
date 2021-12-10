package com.example.chaewonnolja.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import com.example.chaewonnolja.adaptor.RestViewAdapter

class RestFragment : Fragment() {
    private lateinit var restViewAdapter: RestViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_rest, container, false)
    }
    //RecyclerView 불러오기
}