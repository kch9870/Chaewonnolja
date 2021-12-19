package com.example.chaewonnolja.model.service

import com.example.chaewonnolja.model.LoginModel
import com.example.chaewonnolja.model.StringResult
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET




interface NoljaService {

    @Headers(
        "accept: application/json",
        "content-type: application/json"
    )

    @GET("/test")
    fun getRequest(): Call<List<StringResult>>

}