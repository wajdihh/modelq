package com.wajdihh.domain.usecases.demand

import com.nhaarman.mockito_kotlin.mock
import com.wajdihh.domain.interactor.usecase.demand.GetDemandUseCase
import com.wajdihh.domain.mock.DataTest
import com.wajdihh.domain.repository.DemandRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import kotlin.test.assertNotNull

/**
 * Created by wajdihh on 3/17/19.
 * Test get demand by id use case
 */
class GetDemandUseCaseTest {

    private lateinit var getDemandUserCase: GetDemandUseCase
    private lateinit var demandRepository: DemandRepository
    private lateinit var data: DataTest

    @Before
    fun setUp() {
        data = DataTest()
        demandRepository = mock()
        getDemandUserCase = GetDemandUseCase(demandRepository, mock(), mock())
    }

    @Test
    fun checkNotNull() {
        assertNotNull(demandRepository)
        assertNotNull(getDemandUserCase)
    }

    @Test
    fun `repository get success`() {
        //Given
        `when`(demandRepository.getDemandDetails(0)).thenReturn(Single.just(data.demand))
        //When
        val test = getDemandUserCase.buildUseCaseObservable(0).test()
        //Then
        test.assertNoErrors()
    }
}