package com.hs.opendata.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.constants.Constants
import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl
import com.hs.opendata.repository.FavAreaRepo
import com.hs.opendata.repository.FavAreaRepoImpl

class FavAreaViewModel(application: Application) : AndroidViewModel(application) {
    val context: Context = application.applicationContext

    private val areas: MutableLiveData<List<Area>> by lazy {
        MutableLiveData<List<Area>>().also {
            getFavAreaAll()
        }
    }

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getFavAreaAll() {
        FavAreaRepoImpl(AreaDatabase.getDatabase(context)).getFavArea(object :FavAreaRepo.LoadAreaCallback{
            override fun onGetFavAreaResult(areaList: List<Area>) {
                Log.i(Constants.LOG_TAG, "getFavAreaAll ${areaList}")
                areas.value = areaList
            }
        })
    }

    fun deleteArea(area: Area) {
        FavAreaRepoImpl(AreaDatabase.getDatabase(context)).deleteFavArea(area)
    }
}