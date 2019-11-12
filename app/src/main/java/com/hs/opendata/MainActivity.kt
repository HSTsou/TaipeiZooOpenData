package com.hs.opendata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hs.opendata.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_area.setOnClickListener { view -> onClickGetArea() }
    }

    @SuppressLint("CheckResult")
    private fun onClickGetArea() {
        val observable = ApiService.areaApiCall()
            .getArea("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", 25, 0)


        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ userResponse ->
                Log.i("@@HS", userResponse.toString())
            }, { error ->
                Log.i("@@HS", error.toString())
            }
            )
    }
}
