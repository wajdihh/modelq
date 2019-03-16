package com.wajdihh.presentation.mvp.demand.list

import com.wajdihh.domain.interactor.usecase.demand.GetDemandsUseCase
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.presentation.MySingleObserver
import com.wajdihh.presentation.mapper.toDemandsPagingUi
import javax.inject.Inject

class DemandListPresenterImpl @Inject constructor(private val getDemandsUseCase: GetDemandsUseCase) : DemandListPresenter {


    private lateinit var view: DemandListView

    private var searchParams: SearchRequest? = null
    private var total = 0
    private var isShowProgress = true

    override fun attachView(myView: Any) {
        view = myView as DemandListView
    }

    override fun loadMoreDemands(itemCount: Int) {
        searchParams?.let {
            if (itemCount < total) {
                val page = it.page + 1
                isShowProgress = false
                searchForDemands(it.copy(page = page))
            }
        }
    }

    override fun searchForDemands(params: SearchRequest) {
        searchParams = params
        getDemandsUseCase.execute(object : MySingleObserver<DemandsPaging>(view, isShowProgress) {
            override fun onSuccess(t: DemandsPaging) {
                super.onSuccess(t)
                total = t.pager.total
                view.onSuccessLoadList(t.toDemandsPagingUi(myLat = params.lat, myLng = params.lng))
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                view.onErrorLoadList(e)
            }
        }, params)
    }

}