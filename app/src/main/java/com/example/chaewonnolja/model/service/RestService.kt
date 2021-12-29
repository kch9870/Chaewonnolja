package com.example.chaewonnolja.model.service

import android.util.JsonWriter
import com.example.chaewonnolja.model.Repository.getRestbyRegionResult
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET




interface RestService {

    @GET("/rest/region")
    fun getRestRegion(
        @Query("areaName") areaName: String,
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String
    ): Call<getRestbyRegionResult>
}