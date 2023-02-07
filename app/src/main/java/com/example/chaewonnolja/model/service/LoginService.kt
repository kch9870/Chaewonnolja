package com.example.chaewonnolja.model.service

import com.example.chaewonnolja.model.repository.model.JoinResult
import com.example.chaewonnolja.model.repository.model.LoginResult
import retrofit2.Call
import retrofit2.http.*


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