package com.hs.opendata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hs.opendata.constants.Constants
import com.hs.opendata.model.Area
import com.hs.opendata.network.ApiService
import com.hs.opendata.network.response.AreaResponse
import com.hs.opendata.repository.AreaRepo
import com.hs.opendata.repository.AreaRepoImpl
import com.hs.opendata.viewModel.AreaViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var areaViewModel: AreaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_area.setOnClickListener { view -> onClickGetArea() }

        areaViewModel = ViewModelProviders.of(this)[AreaViewModel::class.java]
        areaViewModel.getAreas().observe(this, Observer<List<Area>>{ areas ->
            // update UI
            Log.i(Constants.LOG_TAG, "areas observe $areas")
        })
    }

    @SuppressLint("CheckResult")
    private fun onClickGetArea() {
        areaViewModel.getAreaInfo()
    }
}
