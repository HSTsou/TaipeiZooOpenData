package com.hs.opendata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.hs.opendata.ui.AreaFragment
import com.hs.opendata.viewModel.AreaViewModel


import com.hs.opendata.ui.FavAreaFragment

import com.google.android.material.bottomnavigation.BottomNavigationView




class MainActivity : AppCompatActivity() {

    lateinit var areaViewModel: AreaViewModel

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

    override fun onResume() {
        super.onResume()
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false)
        getSupportActionBar()?.setTitle("Zoo Area")
    }

    fun setupBottomNavigation () {
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
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.bottom_navigation_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle item selection
//        when (item.getItemId()) {
//            R.id.action_area_list -> {
//                val frag = AreaFragment.newInstance()
//                replaceFragment(frag, "AreaListFragment")
//                return true
//            }
//            R.id.action_favorites -> {
//                val frag = FavAreaFragment.newInstance()
//                replaceFragment(frag, "AreaFavFragment")
//                return true
//            }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment, tag).addToBackStack("").commit()
    }
}
