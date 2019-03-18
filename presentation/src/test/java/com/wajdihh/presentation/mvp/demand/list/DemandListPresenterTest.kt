package com.wajdihh.presentation.mvp.demand.list

import com.nhaarman.mockito_kotlin.*
import com.wajdihh.domain.interactor.usecase.demand.GetDemandsUseCase
import com.wajdihh.presentation.mapper.toDemandsPagingUi
import com.wajdihh.presentation.mock.DataTest
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * Created by wajdihh on 3/17/19.
 * Test for presenter
 */
class DemandListPresenterTest {

    private lateinit var presenter: DemandListPresenter
    private lateinit var view: DemandListView
    private lateinit var useCase: GetDemandsUseCase
    private lateinit var data: DataTest

    @Before
    fun setUp() {
        data = DataTest()
        view = mock {
            given(it.isViewAttached()).willReturn(true)
        }
        useCase = mock()
        presenter = DemandListPresenterImpl(useCase)
    }

    @Test
    fun `search for demand success`() {
        //Given
        useCase = mock {
            given(it.buildUseCaseObservable(null)).willReturn(Single.just(data.demandPaging))
        }
        val expected = data.demandPaging.toDemandsPagingUi(0.0, 0.0)
        //when
        presenter.attachView(view)
        presenter.searchForDemands(mock())
        //then
        then(view).should(times(1)).onShowProgress()
        then(view).should(times(1)).onSuccessLoadList(expected)
        then(view).should(times(1)).onHideProgress()
    }

    @Test
    fun `search for demand error`() {
        //Given
        useCase = mock {
            given(it.buildUseCaseObservable(null)).willReturn(Single.error(Exception()))
        }
        //when
        presenter.attachView(view)
        presenter.searchForDemands(mock())
        //then
        then(view).should(times(1)).onShowProgress()
        then(view).should(times(1)).onErrorLoadList(any())
        then(view).should(times(1)).onHideProgress()
    }
}