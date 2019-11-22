package com.hs.opendata.repository

import android.annotation.SuppressLint
import android.util.Log
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface FavAreaRepo {
    interface LoadAreaCallback {
        fun onGetFavAreaResult(areaList: List<Area>)
    }

    fun getFavArea(callback: FavAreaRepo.LoadAreaCallback)

    fun deleteFavArea(area: Area)
}


class FavAreaRepoImpl(var db: AreaDatabase) : FavAreaRepo {

    @SuppressLint("CheckResult")
    override fun getFavArea(callback: FavAreaRepo.LoadAreaCallback) {
        db.areaDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(Constants.LOG_TAG, "getFavArea ${it}")
                callback.onGetFavAreaResult(it)
            }
    }

    @SuppressLint("CheckResult")
    override fun deleteFavArea(area: Area) {
        db.areaDao().deleteArea(area)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(Constants.LOG_TAG, "deleteFavArea ${area.e_Name}")
            }
    }

}
