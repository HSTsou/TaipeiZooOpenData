package com.hs.opendata.viewModel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.repository.AreaRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent


class AreaViewModel(private val repo: AreaRepo) : ViewModel(), KoinComponent {
    private val disposables = CompositeDisposable()
//    private val repo: AreaRepo by inject()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    val areas = MutableLiveData<List<Area>>()
    var isLoading = MutableLiveData<Boolean>()

    fun getAreas(): LiveData<List<Area>> {
        return areas
    }

    fun getAreaInfo() {
        val dis = repo.getAreaInfo().subscribeOn(Schedulers.io())
            .doOnEvent { _, _ -> onLoading() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userResponse ->
                val areaResponse: List<Area> = userResponse?.result?.results
                    ?: throw Exception("areaResponse is null")
                areas.value = areaResponse
                isLoading.postValue(false)
            }, { error ->
                Log.i(Constants.LOG_TAG, error.toString())
                isLoading.postValue(false)
            })

        disposables.add(dis)
    }

    fun saveFavArea(area: Area) {
        val dis = repo.saveFavArea(area)
        disposables.add(dis)
    }

    fun onLoading() {
        isLoading.postValue(true)
    }
}