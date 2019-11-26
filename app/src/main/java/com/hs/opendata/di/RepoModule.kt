package com.hs.opendata.di


import com.hs.opendata.db.AppDatabase
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl
import com.hs.opendata.repository.FavAreaRepo
import com.hs.opendata.repository.FavAreaRepoImpl
import org.koin.dsl.module

val repoModule = module {
    single<AreaRepo> {
        val db = AppDatabase.getDatabase(get())
        AreaRepoImpl(
            db,
            get()
        )
    }

    single<FavAreaRepo> {
        val db = AppDatabase.getDatabase(get())
        FavAreaRepoImpl(
            db
        )
    }
}