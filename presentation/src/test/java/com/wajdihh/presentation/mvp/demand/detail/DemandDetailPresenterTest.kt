package com.wajdihh.presentation.mvp.demand.detail

import com.nhaarman.mockito_kotlin.*
import com.wajdihh.domain.interactor.usecase.demand.GetDemandUseCase
import com.wajdihh.domain.model.Demand
import com.wajdihh.presentation.MySingleObserver
import com.wajdihh.presentation.mapper.toDemandUi
import com.wajdihh.presentation.mock.DataTest
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor



/**
 * Created by wajdihh on 3/18/19.
 * Test for presenter
 */
class DemandDetailPresenterTest {

    private lateinit var presenter: DemandDetailPresenter
    private lateinit var view: DemandDetailView
    private lateinit var useCase: GetDemandUseCase
    private lateinit var data: DataTest

    @Before
    fun setUp() {
        data = DataTest()
        view = mock {
            given(it.isViewAttached()).willReturn(true)
        }
        useCase = mock()
        presenter = DemandDetailPresenterImpl(useCase)
    }

    @Test
    fun `load demand details with success`() {

        //Given
        val captor = argumentCaptor<MySingleObserver<Demand>>()
        val expected = data.demand.toDemandUi()

        //when
        presenter.attachView(view)
        presenter.getDetails(0)

        verify(useCase, times(1)).execute(captor.capture(), any())

        captor.firstValue.onStart()
        captor.firstValue.onSuccess(data.demand)

        //then
        then(view).should(times(1)).onShowProgress()
        then(view).should(times(1)).onSuccessLoadDetails(expected)
        then(view).should(times(1)).onHideProgress()
    }

    @Test
    fun `load demand details with error`() {
        //Given
        val captor = argumentCaptor<MySingleObserver<Demand>>()
        //when
        presenter.attachView(view)
        presenter.getDetails(0)

        verify(useCase, times(1)).execute(captor.capture(), any())

        captor.firstValue.onStart()
        captor.firstValue.onError(mock())

        //then
        then(view).should(times(1)).onShowProgress()
        then(view).should(times(1)).onErrorLoadDetails(any())
        then(view).should(times(1)).onHideProgress()
    }
}