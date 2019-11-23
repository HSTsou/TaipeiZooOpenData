package com.hs.opendata.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.repository.FavAreaRepo
import com.hs.opendata.repository.FavAreaRepoImpl
import io.reactivex.disposables.CompositeDisposable

class FavAreaViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application.applicationContext
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private val areas: MutableLiveData<List<Area>> by lazy {
        MutableLiveData<List<Area>>().also {
            getFavAreaAll()
        }
    }

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getFavAreaAll() {
        val dis = FavAreaRepoImpl(AreaDatabase.getDatabase(context)).getFavArea(object :
            FavAreaRepo.LoadAreaCallback {
            override fun onGetFavAreaResult(areaList: List<Area>) {
                Log.i(Constants.LOG_TAG, "getFavAreaAll ${areaList}")
                areas.value = areaList
            }
        })
        disposables.add(dis)
    }

    fun deleteArea(area: Area) {
        val dis = FavAreaRepoImpl(AreaDatabase.getDatabase(context)).deleteFavArea(area)
        disposables.add(dis)
    }
}