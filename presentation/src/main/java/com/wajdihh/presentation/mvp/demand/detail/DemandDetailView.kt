package com.wajdihh.presentation.mvp.demand.detail

import com.wajdihh.presentation.BaseView
import com.wajdihh.presentation.model.DemandItemUi

interface DemandDetailView : BaseView {
    /**
     * When Loading Details is completed by a success
     */
    fun onSuccessLoadDetails(demand: DemandItemUi)

    /**
     * When Loading Details is completed by an error
     */
    fun onErrorLoadDetails(throwable: Throwable)
}