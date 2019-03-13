package com.wajdihh.presentation.mvp.demand.list

import com.wajdihh.domain.interactor.usecase.demand.GetDemandsUseCase
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.presentation.mapper.toDemandsPagingUi
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class DemandListPresenterImpl @Inject constructor(private val getDemandsUseCase: GetDemandsUseCase) : DemandListPresenter {


    private lateinit var view: DemandListView

    override fun attachView(myView: Any) {
        view = myView as DemandListView
    }

    override fun searchForDemands(params: SearchRequest) {
        view.onShowProgress()
        getDemandsUseCase.execute(object : DisposableSingleObserver<DemandsPaging>() {
            override fun onSuccess(t: DemandsPaging) {
                //if not attached , stop all stuffs
                if(!view.isViewAttached())
                    return

                view.onSuccessLoadList(t.toDemandsPagingUi())
                view.onHideProgress()
            }

            override fun onError(e: Throwable) {
                //if not attached , stop all stuffs
                if(!view.isViewAttached())
                    return

                view.onErrorLoadList(e)
                view.onHideProgress()
            }

        },params)
    }
}