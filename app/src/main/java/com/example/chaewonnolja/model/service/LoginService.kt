package com.example.chaewonnolja.model.service

import android.util.JsonWriter
import com.example.chaewonnolja.model.JoinResult
import com.example.chaewonnolja.model.LoginResult
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET


interface LoginService {

    @FormUrlEncoded
    @POST("/auth/login")
    fun loginRequest(@Field("id") id: String,
                     @Field("password") password: String
    ): Call<LoginResult>

    @FormUrlEncoded
    @POST("/auth/join")
    fun joinRequest(@Field("id") id: String,
                    @Field("password") password: String,
                    @Field("nickName") nickName: String
    ): Call<JoinResult>
}