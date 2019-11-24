package com.hs.opendata.di

import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.viewModel.AreaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        val db = AreaDatabase.getDatabase(get()) // or androidContext()
        AreaViewModel(db)
    }
}