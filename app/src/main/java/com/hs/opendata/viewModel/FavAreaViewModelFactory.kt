package com.hs.opendata.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hs.opendata.db.AreaDatabase

class FavAreaViewModelFactory(val database: AreaDatabase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavAreaViewModel::class.java)) {
            return FavAreaViewModel() as T
        }
        return null as T
    }
}
