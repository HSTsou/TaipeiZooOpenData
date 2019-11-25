package com.hs.opendata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.ui.FavAreaFragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val areaFragment: AreaFragment by inject()
    private val favAreaFragment: FavAreaFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupBottomNavigation()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, areaFragment)
                .commit()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_area_list -> {
                    val frag = areaFragment
                    replaceFragment(frag, "AreaListFragment")

                }
                R.id.action_favorites -> {
                    val frag = favAreaFragment
                    replaceFragment(frag, "FavAreaFragment")

                }
            }
            true
        }
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag).addToBackStack("").commit()
    }
}
