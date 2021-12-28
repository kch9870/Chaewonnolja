package com.example.chaewonnolja.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.model.Repository.getData
import com.example.chaewonnolja.model.Repository.getRestbyRegionResult
import com.example.chaewonnolja.view.adaptor.HighRestViewAdapter
import com.example.chaewonnolja.view.item.HighRestItem
import com.example.chaewonnolja.view.item.RestItem
import kotlinx.android.synthetic.main.fragment_rest.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestFragment : Fragment() {

    lateinit var itemList: MutableList<HighRestItem>
    lateinit var list: MutableList<RestItem>

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

        val noljaClient = NoljaClient()
        noljaClient.restService?.getRestRegion("서울","10","1")?.enqueue(object:
            Callback<getRestbyRegionResult> {
            override fun onFailure(call: Call<getRestbyRegionResult>, t: Throwable) {
                Log.e("Rest", t.toString())
                Log.d("Rest", "fail")
            }
            override fun onResponse(call: Call<getRestbyRegionResult>, response: Response<getRestbyRegionResult>) {
                if (response.isSuccessful()) {
                    Log.d("Rest", response.body().toString())
                    Log.d("Rest_test", response.body()?.data?.get(0)?.title.toString())

                    data= response.body()?.data!!
                    Log.d("Rest_test",data.toString())

                    initRecycler(data)
                }
            }
        })

    }

    fun initRecycler(data: List<getData>) {


        itemList = mutableListOf(
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
