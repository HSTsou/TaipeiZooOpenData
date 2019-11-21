package com.hs.opendata.repository

import android.annotation.SuppressLint
import android.util.Log
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface AreaRepo {

    interface LoadAreaCallback {
        fun onGetAreaResult(areaList: List<Area>)
    }

    fun getAreaInfo(callback: LoadAreaCallback)

    fun saveFavArea(area: Area)
}

class AreaRepoImpl(var db: AreaDatabase) : AreaRepo {
    @SuppressLint("CheckResult")
    lateinit var localDataSource: AreaDatabase

    fun getMockAreaData(): List<Area> {
        var a = listOf(
            Area(

                "http://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
                "", "", 99, "", "Name1", "MemoMemoMemo1", 999, "d"
            ),
            Area(

                "http://www.zoo.gov.tw/iTAP/05_Exhibit/01_FormosanAnimal.jpg",
                "", "", 99, "", "Name2", "MemoMemoMemo2", 999, "d"
            )
        )
        return a
    }

    @SuppressLint("CheckResult")
    override fun getAreaInfo(callback: AreaRepo.LoadAreaCallback) {
        val observable = ApiService.areaApiCall()
            .getArea("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", 0, 0)

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userResponse ->
                val areaResponse: List<Area> = userResponse.result.results

                db.areaDao().insertArea(areaResponse[2])
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Log.i(Constants.LOG_TAG, "finished insert ${areaResponse[2]}")
//                        callback.onGetAreaResult(areaResponse)
//                        db.areaDao().getAll().subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe({
//                                Log.i(Constants.LOG_TAG, "finished get ${it}")
//                            })
                        callback.onGetAreaResult(areaResponse)
                    })


//                callback.onGetAreaResult((getMockAreaData()))
            }, { error ->
                Log.i(Constants.LOG_TAG, error.toString())
                callback.onGetAreaResult((getMockAreaData()))
            })
    }

    @SuppressLint("CheckResult")
    override fun saveFavArea(area: Area) {
        db.areaDao().insertArea(area)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.i(Constants.LOG_TAG, "finished insert ${area}")
            })
    }
}