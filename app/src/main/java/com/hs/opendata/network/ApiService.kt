package com.hs.opendata.network

import com.hs.opendata.constants.Constants
import com.hs.opendata.network.request.AreaRequest
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiService {
    fun areaApiCall() = Retrofit.Builder()
        .baseUrl(Constants.API_BASE_PATH)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(ApiWorker.gsonConverter)
        .client(ApiWorker.client)
        .build()
        .create(AreaRequest::class.java)!!
}