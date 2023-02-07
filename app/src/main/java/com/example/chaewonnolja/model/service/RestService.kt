package com.example.chaewonnolja.model.service

import com.example.chaewonnolja.model.repository.model.getRestbyRegionResult
import retrofit2.Call
import retrofit2.http.*


interface RestService {
    @GET("/rest/region")
    fun getRestRegion(
        @Query("areaName") areaName: String,
        @Query("numOfRows") numOfRows: String,
        @Query("pageNo") pageNo: String
    ): Call<getRestbyRegionResult>
}