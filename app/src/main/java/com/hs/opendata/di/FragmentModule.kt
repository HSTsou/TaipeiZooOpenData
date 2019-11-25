package com.hs.opendata.di

import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.ui.FavAreaFragment
import org.koin.dsl.module

val fragmentModule = module {
    factory { AreaFragment() }
    factory { FavAreaFragment() }
}
