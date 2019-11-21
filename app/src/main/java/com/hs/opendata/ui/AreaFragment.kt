package com.hs.opendata.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hs.opendata.MainActivity
import com.hs.opendata.R
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.viewModel.AreaViewModel

class AreaFragment : Fragment() {
    lateinit var areaViewModel: AreaViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AreaListAdapter

    companion object {
        fun newInstance(): AreaFragment = AreaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment_area, container,
            false
        )

        recyclerView = view.findViewById(R.id.area_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = AreaListAdapter(OnItemClick())
        recyclerView.setAdapter(adapter)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        = view.findViewById(R.id.toolbar)
//        (activity as MainActivity).setSupportActionBar(mToolbar)

        areaViewModel = ViewModelProviders.of(this)[AreaViewModel::class.java]
        areaViewModel.getAreas().observe(this, Observer<List<Area>> { areas ->
            Log.i(Constants.LOG_TAG, "areas observe $areas")
            adapter.updateAreas(areas)
        })
        areaViewModel.getAreaInfo()
    }

    inner class OnItemClick : OnClickCallback {
        override fun onClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, "area: $area, position: $position")

            val frag = AreaInfoFragment.newInstance()
            (activity as MainActivity).replaceFragment(frag, "AreaInfoFragment")
        }

        override fun onLongClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, " onLongClick area: $area, position: $position")
            areaViewModel.saveFavArea(area)
        }
    }
}

interface OnClickCallback {
    fun onClick(view: View, area: Area, position: Int)

    fun onLongClick(view: View, area: Area, position: Int)
}
