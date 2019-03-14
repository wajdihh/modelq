package com.wajdihh.presentation.mvp.demand.list

import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.presentation.BasePresenter
import com.wajdihh.presentation.model.DemandItemUi

interface DemandListPresenter : BasePresenter {

    /**
     * Display the list of demands according specific params
     */
    fun searchForDemands(params : SearchRequest)

    fun saveDemands(demands : List<DemandItemUi>)
}