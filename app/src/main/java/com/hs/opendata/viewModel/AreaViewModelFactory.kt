package com.hs.opendata.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hs.opendata.db.AppDatabase

class AreaViewModelFactory(val database: AppDatabase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AreaViewModel::class.java)) {
//            return AreaViewModel(database.getDatabase()) as T
        }
        return null as T
    }
}
