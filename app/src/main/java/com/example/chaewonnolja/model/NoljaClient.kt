package com.example.chaewonnolja.model

import com.example.chaewonnolja.model.service.LoginService
import com.example.chaewonnolja.model.service.RestService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


class NoljaClient {
    var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .build()

    var retrofit = Retrofit.Builder()
        .baseUrl("http://3.144.155.186:3001")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var loginService = retrofit.create(LoginService::class.java)
    var restService = retrofit.create(RestService::class.java)
}