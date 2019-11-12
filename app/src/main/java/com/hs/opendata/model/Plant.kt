package com.hs.opendata.model

import com.google.gson.annotations.SerializedName

data class Plant(

    @SerializedName("F_Name_Latin") val f_Name_Latin: String,
    @SerializedName("F_pdf02_ALT") val f_pdf02_ALT: String,
    @SerializedName("F_Location") val f_Location: String,
    @SerializedName("F_pdf01_ALT") val f_pdf01_ALT: String,
    @SerializedName("F_Summary") val f_Summary: String,
    @SerializedName("F_Pic01_URL") val f_Pic01_URL: String,
    @SerializedName("F_pdf02_URL") val f_pdf02_URL: String,
    @SerializedName("F_Pic02_URL") val f_Pic02_URL: String,
    @SerializedName("F_Keywords") val f_Keywords: String,
    @SerializedName("F_Code") val f_Code: String,
    @SerializedName("F_Geo") val f_Geo: String,
    @SerializedName("F_Pic03_URL") val f_Pic03_URL: String,
    @SerializedName("F_Voice01_ALT") val f_Voice01_ALT: String,
    @SerializedName("F_AlsoKnown") val f_AlsoKnown: String,
    @SerializedName("F_Voice02_ALT") val f_Voice02_ALT: String,
    @SerializedName("F_Name_Ch") val f_Name_Ch: String,
    @SerializedName("F_Pic04_ALT") val f_Pic04_ALT: String,
    @SerializedName("F_Name_En") val f_Name_En: String,
    @SerializedName("F_Brief") val f_Brief: String,
    @SerializedName("F_Pic04_URL") val f_Pic04_URL: String,
    @SerializedName("F_Voice01_URL") val f_Voice01_URL: String,
    @SerializedName("F_Feature") val f_Feature: String,
    @SerializedName("F_Pic02_ALT") val f_Pic02_ALT: String,
    @SerializedName("F_Family") val f_Family: String,
    @SerializedName("F_Voice03_ALT") val f_Voice03_ALT: String,
    @SerializedName("F_Voice02_URL") val f_Voice02_URL: String,
    @SerializedName("F_Pic03_ALT") val f_Pic03_ALT: String,
    @SerializedName("F_Pic01_ALT") val f_Pic01_ALT: String,
    @SerializedName("F_CID") val f_CID: String,
    @SerializedName("F_pdf01_URL") val f_pdf01_URL: String,
    @SerializedName("F_Vedio_URL") val f_Vedio_URL: String,
    @SerializedName("F_Genus") val f_Genus: String,
    @SerializedName("F_Function＆Application") val f_FunctionApplication: String,
    @SerializedName("F_Voice03_URL") val f_Voice03_URL: String,
    @SerializedName("F_Update") val f_Update: String,
    @SerializedName("_id") val _id: Int
)