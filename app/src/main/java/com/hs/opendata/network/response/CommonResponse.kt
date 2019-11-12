package com.hs.opendata.network.response

import com.google.gson.annotations.SerializedName

data class CommonResponse(
//    @SerializedName("data") val data: Result,
    @SerializedName("status") val status: Int,
    @SerializedName("statusText") val statusText: String
)

data class Result(
    @SerializedName("result") val result: List<ResultResponse>
)