package com.example.chaewonnolja.model.repository.model

import com.google.gson.annotations.SerializedName

/*변수명 response 잘 받기*/

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