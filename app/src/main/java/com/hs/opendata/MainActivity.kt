package com.hs.opendata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.viewModel.AreaViewModel
import com.hs.opendata.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var areaViewModel: AreaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, AreaFragment.newInstance(), "AreaList")
                .commit()
        }


//        activity_mainbtn_get_area.setOnClickListener { view -> onClickGetArea() }
//
//        areaViewModel = ViewModelProviders.of(this)[AreaViewModel::class.java]
//
//        areaViewModel.getAreas().observe(this, Observer<List<Area>>{ areas ->
//            // update UI
//            Log.i(Constants.LOG_TAG, "areas observe $areas")
//        })
    }

//    @SuppressLint("CheckResult")
//    private fun onClickGetArea() {
//        areaViewModel.getAreaInfo()
//    }
}
