package com.wajdihh.presentation.mvp.demand.list

import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.presentation.BasePresenter

interface DemandListPresenter : BasePresenter {

    /**
     * Display the list of demands according specific params
     */
    fun searchForDemands(params : SearchRequest)
}