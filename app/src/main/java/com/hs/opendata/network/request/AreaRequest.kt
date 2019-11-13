package com.hs.opendata.network.request

import com.hs.opendata.network.response.AreaResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AreaRequest {

    //    @Headers("Content-Type: application/json")
    @GET("apiAccess")
    fun getArea(
        @Query("scope") scope: String = "resourceAquire",
        @Query("rid") rid: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Single<AreaResponse>
}
