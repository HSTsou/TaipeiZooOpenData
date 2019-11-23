package com.hs.opendata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.ui.FavAreaFragment

import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupBottomNavigation()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, AreaFragment.newInstance(), "AreaList")
                .commit()
        }
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_area_list -> {
                    val frag = AreaFragment.newInstance()
                    replaceFragment(frag, "AreaListFragment")

                }
                R.id.action_favorites -> {
                    val frag = FavAreaFragment.newInstance()
                    replaceFragment(frag, "AreaFavFragment")

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
