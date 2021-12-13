package com.example.chaewonnolja.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.example.chaewonnolja.R
import kotlinx.android.synthetic.main.fragment_search.*
import android.widget.CalendarView.OnDateChangeListener

import androidx.annotation.NonNull


class SearchFragment : Fragment() {
    var peopleCount=0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calendarSelect()    // 날짜 선택 이벤트
        peoplecountSpinner()    //인원 수 선택 이벤트
    }


    // 날짜 선택 이벤트
    private fun calendarSelect(){
        calendarView.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->

            val date = year.toString() + "/" + (month + 1) + "/" + dayOfMonth
            whenDate.setText(date) // 선택한 날짜로 설정
        })
    }

    //인원 수 선택 이벤트
    private fun peoplecountSpinner() {
        // spinner 안에 값들 리스트로 정리
        val pclist= listOf("1","2","3","4")

        // adapter로 spinner 드롭다운 처리
        val adapter1= activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1,
                pclist)
        }
        peopleSpinner.adapter=adapter1

        //안에 item 을 클릭할 시
        peopleSpinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) {
                    Toast.makeText(activity, pclist[position], Toast.LENGTH_SHORT).show()

                    peopleCount = position
                    Log.d("Test people Count", peopleCount.toString())
                }
            }
            //선택 안 할시
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }
}