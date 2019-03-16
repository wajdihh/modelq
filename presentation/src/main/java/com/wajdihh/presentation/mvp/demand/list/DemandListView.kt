package com.wajdihh.presentation.mvp.demand.list

import com.wajdihh.presentation.BaseView
import com.wajdihh.presentation.model.DemandsPagingUi

interface DemandListView : BaseView{
    /**
     * When Loading list is completed by a success
     */
    fun onSuccessLoadList(demandsPagingUi: DemandsPagingUi)

    /**
     * When Loading list is completed by an error
     */
    fun onErrorLoadList(throwable: Throwable)
}