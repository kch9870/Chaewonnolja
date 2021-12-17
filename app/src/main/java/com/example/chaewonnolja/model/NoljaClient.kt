package com.example.chaewonnolja.model

import retrofit2.Retrofit

class NoljaClient {

    var retrofit = Retrofit.Builder()    // Retrofit 인스턴스 생성하기
        .baseUrl("http://gual.cafe24app.com/") // 반드시 '/'로 마무리
        .addConverterFactory(GsonConverterFactory.create()) // JSON 변환기는 마지막에 등록하는 것이 좋음
        .build()
    var service = retrofit.create(RetrofitService::class.java)    // Retrofit 인스턴스로 인터페이스 객체 구현
}