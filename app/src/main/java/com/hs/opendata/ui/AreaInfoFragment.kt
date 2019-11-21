package com.hs.opendata.ui

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

import com.hs.opendata.MainActivity

import android.view.MenuItem


class AreaInfoFragment : Fragment() {
    lateinit var areaViewModel: AreaViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AreaListAdapter

    companion object {
        fun newInstance(): AreaInfoFragment = AreaInfoFragment()
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
//        adapter = AreaListAdapter(OnItemClick())
//        recyclerView.setAdapter(adapter)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity).getSupportActionBar()?.setTitle("Area Info")
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