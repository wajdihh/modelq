package com.wajdihh.presentation.mvp.demand.detail

import com.wajdihh.domain.interactor.usecase.demand.GetDemandUseCase
import com.wajdihh.domain.model.Demand
import com.wajdihh.presentation.MySingleObserver
import com.wajdihh.presentation.mapper.toDemandUi
import javax.inject.Inject

class DemandDetailPresenterImpl @Inject constructor(private val getDemandUseCase: GetDemandUseCase) : DemandDetailPresenter {

    private lateinit var view: DemandDetailView

    override fun attachView(myView: Any) {
        view = myView as DemandDetailView
    }

    override fun getDetails(id: String) {
        getDemandUseCase.execute(object : MySingleObserver<Demand>(view) {
            override fun onSuccess(t: Demand) {
                super.onSuccess(t)
                view.onSuccessLoadDetails(t.toDemandUi())
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                view.onErrorLoadDetails(e)
            }
        })
    }
}