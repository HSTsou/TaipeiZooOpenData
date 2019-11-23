package com.hs.opendata.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hs.opendata.R
import com.hs.opendata.model.Area

class FavAreaAdapter(onClickCallback: IOnClickCallback) : RecyclerView.Adapter<FavAreaHolder>() {

    var list: List<Area>? = null
    private var mOnClickCallback = onClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavAreaHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.area_list_item, parent, false)
        return FavAreaHolder(view)
    }

    override fun onBindViewHolder(holder: FavAreaHolder, position: Int) {
        if (list == null) {
            return
        }
        val area: Area = list!![position]
        holder.itemView.setOnClickListener(ClickListener(area, position))
        holder.itemView.setOnLongClickListener(LongClickListener(area, position))
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

    inner class ClickListener(area: Area, position: Int) : View.OnClickListener {
        private val mPosition = position
        private val mArea = area
        override fun onClick(v: View?) {
            mOnClickCallback.onClick(v!!, mArea, mPosition)
        }
    }

    inner class LongClickListener(area: Area, position: Int) : View.OnLongClickListener {
        private val mPosition = position
        private val mArea = area

        override fun onLongClick(v: View?): Boolean {
            mOnClickCallback.onLongClick(v!!, mArea, mPosition)
            return true
        }
    }
}

class FavAreaHolder(view: View) :
    RecyclerView.ViewHolder(view) {
    private var mTitleView: TextView? = null
    private var mImageView: ImageView? = null
    private var mDescView: TextView? = null
    private var mOpenDateView: TextView? = null

    init {
        mTitleView = view.findViewById(R.id.list_title)
        mImageView = view.findViewById(R.id.pic)
        mDescView = view.findViewById(R.id.desc)
        mOpenDateView = view.findViewById(R.id.open_date)
    }

    fun bind(area: Area) {
        mTitleView?.text = area.e_Name
        mDescView?.text = area.e_Info
        mOpenDateView?.text = area.e_Memo

        mImageView?.let {
            Glide.with(itemView)
                .load(area.e_Pic_URL)
                .circleCrop()
                .into(it)
        }
    }

}