package com.hs.opendata.viewModel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.hs.opendata.RxImmediateSchedulerRule
import com.hs.opendata.db.AppDatabase
import com.hs.opendata.model.Area
import com.hs.opendata.network.request.AreaRequest
import com.hs.opendata.network.response.AreaResponse
import com.hs.opendata.network.response.ResultResponse
import com.hs.opendata.repository.AreaRepoImpl
import io.reactivex.Single
import junit.framework.Assert.assertNotNull
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class AreaViewModelTest {

    @get:Rule
    val schedulers = RxImmediateSchedulerRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var areaRepo: AreaRepoImpl
    @Mock
    lateinit var db: AppDatabase
    @Mock
    lateinit var areaRequest: AreaRequest

    lateinit var areaViewModel: AreaViewModel

    @Mock
    var areaListObserver: Observer<List<Area>>? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        areaRepo = AreaRepoImpl(db, areaRequest)
        areaViewModel = AreaViewModel(areaRepo)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getAreaInfo() {

    }

    @Test
    fun updateAreaInfoData() {
        `when`(areaRepo.getAreaInfo())
            .thenReturn(
                Single.just(
                    AreaResponse(
                        ResultResponse(
                            0,
                            0,
                            0,
                            "",
                            areaRepo.getMockAreaData()
                        )
                    )
                )
            )
        areaViewModel.getAreaInfo()
        assertNotNull(areaListObserver)
    }

    @Test
    fun saveFavArea() {
    }
}