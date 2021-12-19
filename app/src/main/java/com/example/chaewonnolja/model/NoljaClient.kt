package com.example.chaewonnolja.model

import com.example.chaewonnolja.model.service.NoljaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NoljaClient {
    var retrofit = Retrofit.Builder()    // Retrofit 인스턴스 생성하기
        .baseUrl("https://3.144.155.186:3001/") // 반드시 '/'로 마무리
        .addConverterFactory(GsonConverterFactory.create()) // JSON 변환기는 마지막에 등록하는 것이 좋음
        .build()
    var service = retrofit.create(NoljaService::class.java)    // Retrofit 인스턴스로 인터페이스 객체 구현
}