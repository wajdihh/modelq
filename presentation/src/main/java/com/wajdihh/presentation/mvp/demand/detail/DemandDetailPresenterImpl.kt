package com.wajdihh.presentation.mvp.demand.detail

import com.wajdihh.domain.interactor.usecase.demand.GetDemandUseCase
import com.wajdihh.domain.model.Demand
import com.wajdihh.presentation.mapper.toDemandUi
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DemandDetailPresenterImpl @Inject constructor(private val getDemandUseCase: GetDemandUseCase) : DemandDetailPresenter {

    private lateinit var view: DemandDetailView

    override fun attachView(myView: Any) {
        view = myView as DemandDetailView
    }

    override fun getDetails(id: String) {

        view.onShowProgress()
        getDemandUseCase.execute(object : DisposableSingleObserver<Demand>() {
            override fun onSuccess(t: Demand) {
                //if not attached , stop all stuffs
                if(!view.isViewAttached())
                    return

                view.onSuccessLoadDetails(t.toDemandUi())
                view.onHideProgress()
            }

            override fun onError(e: Throwable) {
                //if not attached , stop all stuffs
                if(!view.isViewAttached())
                    return

                view.onErrorLoadDetails(e)
                view.onHideProgress()
            }

        })
    }
}