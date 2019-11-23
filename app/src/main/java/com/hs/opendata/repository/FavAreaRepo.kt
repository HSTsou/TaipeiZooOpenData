package com.hs.opendata.repository

import android.annotation.SuppressLint
import android.util.Log
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface FavAreaRepo {
    interface LoadAreaCallback {
        fun onGetFavAreaResult(areaList: List<Area>)
    }

    fun getFavArea(callback: LoadAreaCallback): Disposable

    fun deleteFavArea(area: Area): Disposable
}


class FavAreaRepoImpl(val db: AreaDatabase) : FavAreaRepo {

    @SuppressLint("CheckResult")
    override fun getFavArea(callback: FavAreaRepo.LoadAreaCallback): Disposable {
        return db.areaDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(Constants.LOG_TAG, "getFavArea ${it}")
                callback.onGetFavAreaResult(it)
            }
    }

    @SuppressLint("CheckResult")
    override fun deleteFavArea(area: Area): Disposable {
        return db.areaDao().deleteArea(area)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.i(Constants.LOG_TAG, "deleteFavArea ${area.e_Name}")
            }
    }

}
