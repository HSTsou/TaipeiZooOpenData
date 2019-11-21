package com.hs.opendata.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "area_fav")
data class Area(

    @SerializedName("E_Pic_URL") var e_Pic_URL: String,
    @SerializedName("E_Geo") var e_Geo: String,
    @SerializedName("E_Info") var e_Info: String,
    @SerializedName("E_no") var e_no: Int,
    @SerializedName("E_Category") var e_Category: String,
    @ColumnInfo(name = "E_Name")@SerializedName("E_Name") var e_Name: String,
    @SerializedName("E_Memo") var e_Memo: String,
    @PrimaryKey@SerializedName("_id") var _id: Int,
    @SerializedName("E_URL") var e_URL: String
)