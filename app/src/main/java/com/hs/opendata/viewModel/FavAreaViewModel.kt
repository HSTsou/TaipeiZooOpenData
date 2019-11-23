package com.hs.opendata.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.repository.FavAreaRepo
import com.hs.opendata.repository.FavAreaRepoImpl
import io.reactivex.disposables.CompositeDisposable

class FavAreaViewModel(val db: AreaDatabase) : ViewModel() {
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

    private fun getFavAreaAll() {
        val dis = FavAreaRepoImpl(db).getFavArea(object :
            FavAreaRepo.LoadAreaCallback {
            override fun onGetFavAreaResult(areaList: List<Area>) {
                Log.i(Constants.LOG_TAG, "getFavAreaAll ${areaList}")
                areas.value = areaList
            }
        })
        disposables.add(dis)
    }

    fun deleteArea(area: Area) {
        val dis = FavAreaRepoImpl(db).deleteFavArea(area)
        disposables.add(dis)
    }
}