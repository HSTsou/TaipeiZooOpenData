package com.hs.opendata.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl

class AreaViewModel(application: Application) : AndroidViewModel(application) {
    val context: Context = application.applicationContext
    private val areas: MutableLiveData<List<Area>> by lazy {
        MutableLiveData<List<Area>>().also {
            getAreaInfo()
        }
    }

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getAreaInfo() {
        AreaRepoImpl(AreaDatabase.getDatabase(context)).getAreaInfo(object : AreaRepo.LoadAreaCallback {
            override fun onGetAreaResult(areaList: List<Area>) {
                areas.value = areaList
            }
        })
    }

    fun saveFavArea(area: Area) {
        AreaRepoImpl(AreaDatabase.getDatabase(context)).saveFavArea(area)
    }
}