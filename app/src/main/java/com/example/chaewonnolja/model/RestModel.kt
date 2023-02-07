package com.example.chaewonnolja.model.repository.model

import com.google.gson.annotations.SerializedName

data class getRestbyRegionResult(
    @SerializedName("totalCount")
    var totalCount: Number? = 0,
    @SerializedName("numOfRows")
    var numOfRows: Number? = 0,
    @SerializedName("pageNo")
    var pageNo: Number? = 0,
    @SerializedName("data")
    var data: List<getData> ?= null
)

data class getData(
    @SerializedName("contentid")
    var contentid: Number?=0,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("addr1")
    var addr1: String? = null,
    @SerializedName("addr2")
    var addr2: String? = null,
    @SerializedName("firstimage")
    var firstimage: String? = null,
    @SerializedName("tel")
    var tel: String? = null
)
