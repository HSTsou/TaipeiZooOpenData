package com.hs.opendata.network.response

import com.google.gson.annotations.SerializedName
import com.hs.opendata.model.Area

data class ResultResponse(
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("sort") val sort: String,
    @SerializedName("results") val results: List<Area>
)