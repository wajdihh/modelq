package com.wajdihh.presentation.mvp.demand.detail

import com.wajdihh.presentation.BasePresenter

interface DemandDetailPresenter : BasePresenter {

    /**
     * Display the details of a demand
     */
    fun getDetails(id: Int)
}