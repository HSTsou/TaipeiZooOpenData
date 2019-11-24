package com.hs.opendata.di


import com.hs.opendata.repository.AreaRepoImpl
import org.koin.dsl.module

val repoModule = module {
    single {
        AreaRepoImpl(get())
    }
}