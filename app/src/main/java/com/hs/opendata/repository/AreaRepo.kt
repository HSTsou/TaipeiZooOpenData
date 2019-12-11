package com.hs.opendata.repository

import android.annotation.SuppressLint
import android.util.Log
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AppDatabase
import com.hs.opendata.model.Area
//import com.hs.opendata.network.ApiService
import com.hs.opendata.network.request.AreaRequest
import com.hs.opendata.network.response.AreaResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface AreaRepo {

    interface LoadAreaCallback {
        fun onSuccess(areaList: List<Area>)

        fun onError(error: Throwable)
    }

    fun getAreaInfo(): Single<AreaResponse>

    fun saveFavArea(area: Area): Disposable
}

class AreaRepoImpl(var db: AppDatabase, private val api: AreaRequest) : AreaRepo {
    fun getMockAreaData(): List<Area> {
        return listOf(
            Area(
                "http://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
                "", "", 99, "", "Name1", "MemoMemoMemo1", 999, "d"
            ),
            Area(
                "http://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
                "", "", 99, "", "Name2", "MemoMemoMemo2", 999, "d"
            )
        )
    }

    @SuppressLint("CheckResult")
    override fun getAreaInfo(): Single<AreaResponse> {
        return api
            .getArea("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", 0, 0)
    }

    @SuppressLint("CheckResult")
    override fun saveFavArea(area: Area): Disposable {
        return db.areaDao().insertArea(area)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(Constants.LOG_TAG, "finished insert $area")
            }
    }
}