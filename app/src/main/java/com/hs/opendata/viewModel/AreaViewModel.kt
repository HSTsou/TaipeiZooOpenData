package com.hs.opendata.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl
import io.reactivex.disposables.CompositeDisposable


class AreaViewModel(val db: AreaDatabase) : ViewModel() {
    private val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private val areas: MutableLiveData<List<Area>> by lazy {
        MutableLiveData<List<Area>>().also {
            getAreaInfo()
        }
    }

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getAreaInfo() {
        val dis = AreaRepoImpl(db).getAreaInfo(object :
            AreaRepo.LoadAreaCallback {
            override fun onGetAreaResult(areaList: List<Area>) {
                areas.value = areaList
            }
        })
        disposables.add(dis)
    }

    fun saveFavArea(area: Area) {
        val dis = AreaRepoImpl(db).saveFavArea(area)
        disposables.add(dis)
    }
}