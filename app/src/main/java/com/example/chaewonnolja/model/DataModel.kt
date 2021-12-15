package com.example.chaewonnolja.model

data class LoginModel(
    var uid: Long = 0
)
data class JoinModel(
    var uid: Long = 0,
    var uname: String? = null,
    var id: Long = 0,
    var password: String?=null
)