package com.hs.opendata.repository

import android.annotation.SuppressLint
import android.util.Log
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.network.ApiService
import com.hs.opendata.network.response.AreaResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface AreaRepo {

    interface LoadAreaCallback {
        fun onGetAreaResult(areas: List<Area>)
    }

    fun getAreaInfo(callback: LoadAreaCallback)
}

class AreaRepoImpl() : AreaRepo {
    @SuppressLint("CheckResult")

    override fun getAreaInfo(callback: AreaRepo.LoadAreaCallback) {
        val observable = ApiService.areaApiCall()
            .getArea("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", 1, 0)

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userResponse ->
                Log.i(Constants.LOG_TAG, userResponse.result.results[0].toString())

                val areaResponse: List<Area> = userResponse.result.results
                callback.onGetAreaResult(areaResponse)
            }, { error ->
                Log.i(Constants.LOG_TAG, error.toString())
            })
    }
}