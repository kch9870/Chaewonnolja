package com.example.chaewonnolja.model.service

import android.util.JsonWriter
import com.example.chaewonnolja.model.Repository.getRestbyRegionResult
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET




interface RestService {

    @FormUrlEncoded
    @POST("/rest/region")
    fun getRestRegion(
        @Field("areaName") areaName: String,
        @Field("numOfRows") numOfRows: String,
        @Field("pageNo") pageNo: String
    ): Call<getRestbyRegionResult>
}