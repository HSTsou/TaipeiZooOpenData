package com.hs.opendata.model

import com.google.gson.annotations.SerializedName

data class Area(

    @SerializedName("E_Pic_URL") var e_Pic_URL: String,
    @SerializedName("E_Geo") var e_Geo: String,
    @SerializedName("E_Info") var e_Info: String,
    @SerializedName("E_no") var e_no: Int,
    @SerializedName("E_Category") var e_Category: String,
    @SerializedName("E_Name") var e_Name: String,
    @SerializedName("E_Memo") var e_Memo: String,
    @SerializedName("_id") var _id: Int,
    @SerializedName("E_URL") var e_URL: String
)