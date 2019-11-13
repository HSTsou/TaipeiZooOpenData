package com.hs.opendata.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl

class AreaViewModel() : ViewModel() {
    private val areas: MutableLiveData<List<Area>> by lazy {
        MutableLiveData<List<Area>>().also {
            getAreaInfo()
        }
    }

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getAreaInfo() {
        AreaRepoImpl().getAreaInfo(object : AreaRepo.LoadAreaCallback {
            override fun onGetAreaResult(areaResults: List<Area>) {
//                Log.i(Constants.LOG_TAG, "areas onGetAreaResult $areas")
                areas.value = areaResults
            }
        })
    }
}