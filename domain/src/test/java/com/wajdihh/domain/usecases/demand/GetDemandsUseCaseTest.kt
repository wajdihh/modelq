package com.wajdihh.domain.usecases.demand

import com.nhaarman.mockito_kotlin.mock
import com.wajdihh.domain.interactor.usecase.demand.GetDemandsUseCase
import com.wajdihh.domain.mock.DataTest
import com.wajdihh.domain.repository.DemandRepository
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import kotlin.test.assertNotNull

/**
 * Created by wajdihh on 3/17/19.
 * Test get demands use case
 */
class GetDemandsUseCaseTest {

    private lateinit var getDemandsUserCase: GetDemandsUseCase
    private lateinit var demandRepository: DemandRepository
    private lateinit var data: DataTest

    @Before
    fun setUp() {
        data = DataTest()
        demandRepository = mock()
        getDemandsUserCase = GetDemandsUseCase(demandRepository, mock(), mock())
    }

    @Test
    fun checkNotNull() {
        assertNotNull(demandRepository)
        assertNotNull(getDemandsUserCase)
    }

    @Test
    fun `repository get success`() {
        //Given
        `when`(demandRepository.getDemands(null)).thenReturn(Single.just(data.demandPaging))
        //When
        val test = getDemandsUserCase.buildUseCaseObservable(null).test()
        //Then
        test.assertNoErrors()
    }
}