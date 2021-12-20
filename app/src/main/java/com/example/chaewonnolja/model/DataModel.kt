package com.example.chaewonnolja.model

import com.google.gson.annotations.SerializedName

/*변수명 response 잘 받기*/

data class LoginModel(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("password")
    var password: String? = null
)

data class JoinModel(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("password")
    var password: String?=null,
    @SerializedName("nickName")
    var nickName: String? = null
)
data class JoinResult(
    @SerializedName("state")
    var state: Boolean?=false,
    @SerializedName("msg")
    var msg: String? = null,
    @SerializedName("nickName")
    var nickName: String? = null
)
data class LoginResult(
    @SerializedName("state")
    var state: Boolean?=false,
    @SerializedName("msg")
    var msg: String? = null,
    @SerializedName("nickName")
    var nickName: String? = null
)