package com.hs.opendata.di

import com.hs.opendata.viewModel.AreaViewModel
import com.hs.opendata.viewModel.FavAreaViewModel
import org.koin.dsl.module


val viewModelModule = module {
    factory {
//        val db = AreaDatabase.getDatabase(get()) // or androidContext()
        AreaViewModel()
    }

    factory {
        FavAreaViewModel()
    }
}