package com.wajdihh.data.source.remote

import com.wajdihh.data.BuildConfig
import com.wajdihh.data.factory.DataRemoteFactory
import com.wajdihh.data.source.mock.ConnectivityInterceptorTest
import com.wajdihh.data.source.mock.DataConfig
import com.wajdihh.data.source.mock.DataTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

/**
 * Created by wajdihh on 3/17/19.
 * Integration test for service demand
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class DemandServiceTest {

    private lateinit var demandService: DemandService

    @Before
    fun init() {
        demandService = DataRemoteFactory.createDemandService(DataConfig.BASE_URL, ConnectivityInterceptorTest())
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeNull() {
        assertNotNull(demandService)
    }

    @Test
    fun getDemands() {
        val testObserve = demandService.getDemands(DataTest.params.lat,
                DataTest.params.lng,
                DataTest.params.radius,
                DataTest.params.type,
                DataTest.params.page,
                DataTest.params.perPage).test()

        testObserve.assertNoErrors()
    }

    @Test
    fun getDemandById() {
        val testObserve = demandService.getDemand(DataTest.demandId).test()
        testObserve.assertNoErrors()
    }
}