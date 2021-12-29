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
<<<<<<< HEAD
import com.example.chaewonnolja.view.activity.RestInfoActivity
import com.example.chaewonnolja.view.adaptor.OutRecyclerViewAdapter
import com.example.chaewonnolja.view.adaptor.RestViewAdapter
=======
import com.example.chaewonnolja.view.adaptor.HighRestViewAdapter
>>>>>>> fed3ceba352d429905863b04ffd49f092bc840a5
import com.example.chaewonnolja.view.item.HighRestItem
import com.example.chaewonnolja.view.item.RestItem
import kotlinx.android.synthetic.main.fragment_rest.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestFragment : Fragment() {
<<<<<<< HEAD
    lateinit var outRecyclerViewAdapter: OutRecyclerViewAdapter
    val datas = mutableListOf<HighRestItem>()
=======

    lateinit var itemList: MutableList<HighRestItem>
    lateinit var list: MutableList<RestItem>
>>>>>>> fed3ceba352d429905863b04ffd49f092bc840a5

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

<<<<<<< HEAD
=======
                    data= response.body()?.data!!
                    Log.d("Rest_test",data.toString())

                    initRecycler(data)
>>>>>>> fed3ceba352d429905863b04ffd49f092bc840a5
                }
            }
        })

<<<<<<< HEAD
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
=======
    }

    fun initRecycler(data: List<getData>) {


        //for문 처리 어떻게 해야될지 고민... 함수로 빼보자
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
>>>>>>> fed3ceba352d429905863b04ffd49f092bc840a5
