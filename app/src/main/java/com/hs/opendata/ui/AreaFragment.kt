package com.hs.opendata.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hs.opendata.R
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.viewModel.AreaViewModel

class AreaFragment : Fragment() {
    lateinit var areaViewModel: AreaViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var adapter:AreaListAdapter

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
        recyclerView = view.findViewById<RecyclerView>(R.id.area_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = AreaListAdapter()
        recyclerView.setAdapter(adapter)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        areaViewModel = ViewModelProviders.of(this)[AreaViewModel::class.java]
        areaViewModel.getAreas().observe(this, Observer<List<Area>>{ areas ->
            Log.i(Constants.LOG_TAG, "areas observe $areas")
            adapter.updateAreas(areas)
        })
        areaViewModel.getAreaInfo()
    }
}
