package com.hs.opendata.db

import android.database.Observable
import androidx.room.*
import com.hs.opendata.model.Area
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface AreaDao {
    @Query("SELECT * FROM 'area_fav'")
    fun getAll(): Flowable<List<Area>>
//
//    @Query("SELECT * FROM 'area_fav' WHERE 'id' = :id")
//    fun getPostById(id: String): Observable<Area>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertArea(area: Area): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateArea(area: Area)

    @Delete
    fun deleteNewPost(area: Area)
//
//    @Transaction
//    fun upsert(area: Area) {
//        if (-1L == insertArea(area)) {
//            updateArea(area)
//        }
//    }
}