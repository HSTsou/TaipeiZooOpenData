package com.hs.opendata.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hs.opendata.MainActivity
import com.hs.opendata.R
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.viewModel.AreaViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AreaFragment : Fragment() {
    private val areaViewModel: AreaViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AreaListAdapter

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
        recyclerView.adapter = adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        areaViewModel = ViewModelProviders.of(
//            this, AreaViewModelFactory(
//                AppDatabase.getDatabase(requireContext())
//            )
//        ).get(AreaViewModel::class.java)
        areaViewModel.getAreas().observe(this, Observer<List<Area>> { areas ->
            Log.i(Constants.LOG_TAG, "areas observe $areas")
            adapter.updateAreas(areas)
        })
        areaViewModel.getAreaInfo()
    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity).supportActionBar?.title = "Area List"
    }

    inner class OnItemClick : IOnClickCallback {
        override fun onClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, "area: $area, position: $position")

//            val frag = FavAreaFragment.newInstance()
//            (activity as MainActivity).replaceFragment(frag, "FavAreaFragment")
        }

        override fun onLongClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, " onLongClick area: $area, position: $position")
            areaViewModel.saveFavArea(area)
            Toast.makeText(context, "Add area: ${area.e_Name} to Fav", Toast.LENGTH_SHORT).show()
        }
    }
}

