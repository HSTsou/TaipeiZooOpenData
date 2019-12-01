package com.hs.opendata.viewModel

import android.content.Context
import com.hs.opendata.db.AppDatabase
import com.hs.opendata.network.request.AreaRequest
import com.hs.opendata.repository.AreaRepoImpl
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.stubbing.Answer
import java.util.*

class AreaViewModelTest {

    @Mock
    lateinit var areaRepo: AreaRepoImpl
    @Mock
    lateinit var db: AppDatabase
    @Mock
    lateinit var areaRequest: AreaRequest

    @Mock
    lateinit var areaViewModel: AreaViewModel

    @Before
    fun setUp() {
        val context: Context = mock(Context::class.java)
        areaRequest = mock(AreaRequest::class.java)
        db = AppDatabase.getDatabase(context)
        areaRepo = AreaRepoImpl(db, areaRequest)
//        var areaRepo: AreaRepoImpl = spy(AreaRepoImpl::class.java)
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
//        `when`(areaViewModel.getAreaInfo())
//            .thenReturn({ Observable.just(areaRepo.getMockAreaData()) })
//        areaViewModel.getAreaInfo()
//        areaViewModel.areas.value = areaRepo.getMockAreaData()

//        Assert.assertEquals(areaRepo.getMockAreaData(), areaViewModel.areas.value)
    }

    @Test
    fun saveFavArea() {
    }
}