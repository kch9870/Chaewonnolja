package com.example.chaewonnolja.model

data class LoginModel(
    var id: String? = null,
    var password: String? = null
)
data class JoinModel(
    var uid: Long = 0,
    var uname: String? = null,
    var id: Long = 0,
    var password: String?=null
)
data class StringResult(
    var result: String? = null
)