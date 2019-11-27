package com.hs.opendata.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hs.opendata.R
import com.hs.opendata.constants.Constants

import com.hs.opendata.MainActivity

import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hs.opendata.model.Area
import com.hs.opendata.viewModel.FavAreaViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class FavAreaFragment : Fragment() {
    private val favAreaViewModel: FavAreaViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FavAreaAdapter

    companion object {
        fun newInstance(): FavAreaFragment = FavAreaFragment()
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
        adapter = FavAreaAdapter(OnItemClick())
        recyclerView.adapter = adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity).supportActionBar?.title = "Favorite Area"

//        favAreaViewModel = ViewModelProviders.of(
//            this, FavAreaViewModelFactory(
//                AppDatabase.getDatabase(requireContext())
//            )
//        ).get(FavAreaViewModel::class.java)
        favAreaViewModel.getAreas().observe(this, Observer<List<Area>> { areas ->
            Log.i(Constants.LOG_TAG, "areas observe $areas")
            adapter.updateAreas(areas)
        })
    }

    inner class OnItemClick : IOnClickCallback {
        override fun onClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, "area: $area, position: $position")
        }

        override fun onLongClick(view: View, area: Area, position: Int) {
            Log.i(Constants.LOG_TAG, " onLongClick delete area: $area, position: $position")
            Toast.makeText(context, "Delete area: ${area.e_Name}", Toast.LENGTH_SHORT).show()
            favAreaViewModel.deleteArea(area)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                Log.i(Constants.LOG_TAG, "click back")
                return true
            }


            else -> return super.onOptionsItemSelected(item)
        }
    }

}