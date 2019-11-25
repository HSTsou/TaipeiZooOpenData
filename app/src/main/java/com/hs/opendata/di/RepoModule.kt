package com.hs.opendata.di


import com.hs.opendata.db.AreaDatabase
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl
import com.hs.opendata.repository.FavAreaRepo
import com.hs.opendata.repository.FavAreaRepoImpl
import org.koin.dsl.module

val repoModule = module {
    single<AreaRepo> {
        val db = AreaDatabase.getDatabase(get())
        AreaRepoImpl(
            db
        )
    }

    single<FavAreaRepo> {
        val db = AreaDatabase.getDatabase(get())
        FavAreaRepoImpl(
            db
        )
    }
}