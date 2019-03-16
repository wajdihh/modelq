package com.wajdihh.presentation.mvp.demand.detail

import com.wajdihh.presentation.BaseView
import com.wajdihh.presentation.model.DemandUi

interface DemandDetailView : BaseView {
    /**
     * When Loading Details is completed by a success
     */
    fun onSuccessLoadDetails(demand: DemandUi)

    /**
     * When Loading Details is completed by an error
     */
    fun onErrorLoadDetails(throwable: Throwable)
}