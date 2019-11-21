package com.hs.opendata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.viewModel.AreaViewModel


class MainActivity : AppCompatActivity() {

    lateinit var areaViewModel: AreaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, AreaFragment.newInstance(), "AreaList")
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false)
        getSupportActionBar()?.setTitle("Zoo Area")
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag).addToBackStack("").commit()
    }
}
