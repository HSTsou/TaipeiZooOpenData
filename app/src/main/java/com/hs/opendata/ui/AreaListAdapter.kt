package com.hs.opendata.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hs.opendata.R
import com.hs.opendata.model.Area

class AreaListAdapter : RecyclerView.Adapter<AreaViewHolder>() {

    var list:List<Area>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AreaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        if (list == null) {
            return
        }
        val area: Area = list!![position]
        holder.bind(area)
    }

    override fun getItemCount(): Int {
        if (list == null) {
            return 0
        }
        return list!!.size
    }

    fun updateAreas(areas: List<Area>) {
        list = areas
        notifyDataSetChanged()
    }

}

class AreaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.area_list_item, parent, false)) {
    private var mTitleView: TextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.list_title)
    }

    fun bind(area: Area) {
        mTitleView?.text = area.e_Name
    }

}