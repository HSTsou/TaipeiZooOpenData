package com.hs.opendata.db

import android.content.Context
import androidx.room.*
import com.hs.opendata.model.Area
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.migration.Migration
import android.icu.lang.UCharacter.GraphemeClusterBreak.V


@Database(entities = [Area::class], version = 2, exportSchema = false)
abstract class AreaDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: AreaDatabase? = null

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE area_fav " + " ADD COLUMN E_Name TEXT")
            }
        }

        fun getDatabase(context: Context): AreaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AreaDatabase::class.java,
                    "area_database"
                ).addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun areaDao(): AreaDao


}