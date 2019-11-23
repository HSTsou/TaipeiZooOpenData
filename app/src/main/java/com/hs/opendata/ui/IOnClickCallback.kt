package com.hs.opendata.ui

import android.view.View
import com.hs.opendata.model.Area

interface IOnClickCallback {
    fun onClick(view: View, area: Area, position: Int)
    fun onLongClick(view: View, area: Area, position: Int)
}