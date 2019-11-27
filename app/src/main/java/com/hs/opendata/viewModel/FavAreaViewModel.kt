package com.hs.opendata.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.repository.FavAreaRepo
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

class FavAreaViewModel : ViewModel(), KoinComponent {
    private val disposables = CompositeDisposable()
    private val repo: FavAreaRepo by inject()

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
        val dis = repo.getFavArea(object :
            FavAreaRepo.LoadAreaCallback {
            override fun onGetFavAreaResult(areaList: List<Area>) {
//                Log.i(Constants.LOG_TAG, "getFavAreaAll $areaList")
                areas.value = areaList
            }
        })
        disposables.add(dis)
    }

    fun deleteArea(area: Area) {
        val dis = repo.deleteFavArea(area)
        disposables.add(dis)
    }
}