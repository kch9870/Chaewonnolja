package com.example.chaewonnolja.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chaewonnolja.R
import com.example.chaewonnolja.model.NoljaClient
import com.example.chaewonnolja.model.Repository.getRestbyRegionResult
import com.example.chaewonnolja.view.activity.RestInfoActivity
import com.example.chaewonnolja.view.adaptor.OutRecyclerViewAdapter
import com.example.chaewonnolja.view.adaptor.RestViewAdapter
import com.example.chaewonnolja.view.item.HighRestItem
import com.example.chaewonnolja.view.item.RestItem
import kotlinx.android.synthetic.main.fragment_rest.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestFragment : Fragment() {
    lateinit var outRecyclerViewAdapter: OutRecyclerViewAdapter
    val datas = mutableListOf<HighRestItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_rest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Retrofit 통신
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

                }
            }
        })

        setUpRecyclerView()
    }

    //RecyclerView 불러오기
    fun initRecycler() {
        outRecyclerViewAdapter = activity?.let { OutRecyclerViewAdapter(it,item.itemList) }!!
        rv_rest.adapter = outRecyclerViewAdapter

        //데이터 값 넣어보기 대충
        datas.apply {
            add(HighRestItem("서울시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ))

            outRecyclerViewAdapter.datas = datas
            outRecyclerViewAdapter.notifyDataSetChanged()

//            outRecyclerViewAdapter.setOnItemClickListener(object : RestViewAdapter.OnItemClickListener{
//                override fun onItemClick(v: View, data: RestItem, pos : Int) {
//                    activity?.let{
//                        val intent = Intent(context, RestInfoActivity::class.java)
//                        startActivity(intent)
//                    }
//                }
//
//            })

        }
    }

    private fun setUpRecyclerView() {
        var itemList = mutableListOf(
            HighRestItem("서울시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ),
            HighRestItem("강릉시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ),
            HighRestItem("부산시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ),
            HighRestItem("광주시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ),
            HighRestItem("충주시", mutableListOf(
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔"),
                RestItem(restImage = R.drawable.rest, restName = "Mary Hotel", restCategory = "호텔")
            )
            ),
        )

        rv_rest.adapter = OutRecyclerViewAdapter(requireContext(), itemList)
        rv_rest.layoutManager = LinearLayoutManager(requireContext())

//        rv_rest.adapter.setOnItemClickListener(object : RestViewAdapter.OnItemClickListener{
//            override fun onItemClick(v: View, data: RestItem, pos : Int) {
//                activity?.let{
//                    val intent = Intent(context, RestInfoActivity::class.java)
//                    startActivity(intent)
//                }
//            }
//
//        })
    }
}