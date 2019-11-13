package com.hs.opendata.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.hs.opendata.constants.Constants
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

    //    var productPrice: ObservableField<Int> = ObservableField(0)
//    var productItems: ObservableField<String> = ObservableField("")

    fun getAreaInfo() {
        AreaRepoImpl().getAreaInfo(object : AreaRepo.LoadAreaCallback {
            override fun onGetAreaResult(areas: List<Area>) {
                //TODO
                Log.i(Constants.LOG_TAG, "areas $areas")
            }
//            override fun onProductResult(productResponse: ProductResponse) {
//                productName.set(productResponse.name)
//                productDesc.set(productResponse.desc)
//                productPrice.set(productResponse.price)
//            }
        })
    }
}