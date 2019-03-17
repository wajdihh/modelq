package com.wajdihh.data.source.local

import android.arch.persistence.room.Room
import com.wajdihh.data.BuildConfig
import com.wajdihh.data.source.mock.DataTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

/**
 * Created by wajdihh on 3/17/19.
 * Testing DataBase
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)

class DemandDaoTest {

    private lateinit var mDatabase: MyDatabase


    @Before
    fun init() {
        val context = RuntimeEnvironment.application
        mDatabase = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
                .allowMainThreadQueries()
                .build()

    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeNull() {
        assertNotNull(mDatabase)
    }

    @Test
    fun testDemandWriteAndRead() {
        //insert it in DB
        mDatabase.demandDao().saveDemands(DataTest.demandEntities)
        //get result form DB
        val testObserver = mDatabase.demandDao().getDemands().map { it.first().firstName }.test()

        testObserver.assertNoErrors()
        testObserver.assertValue(DataTest.demandEntities.first().firstName)
    }

    @After
    @Throws(Exception::class)
    fun closeDb() {
        mDatabase.close()
    }
}