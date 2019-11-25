package com.hs.opendata.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject



class AreaViewModel : ViewModel(), KoinComponent {
    private val disposables = CompositeDisposable()
    private val repo: AreaRepo by inject()

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
        val dis = repo.getAreaInfo(object :
            AreaRepo.LoadAreaCallback {
            override fun onGetAreaResult(areaList: List<Area>) {
                areas.value = areaList
            }
        })
        disposables.add(dis)
    }

    fun saveFavArea(area: Area) {
        val dis = repo.saveFavArea(area)
        disposables.add(dis)
    }
}