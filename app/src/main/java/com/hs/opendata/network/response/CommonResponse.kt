package com.hs.opendata.network.response

import com.google.gson.annotations.SerializedName

data class CommonResponse(
    @SerializedName("result") val result: ResultResponse
)
