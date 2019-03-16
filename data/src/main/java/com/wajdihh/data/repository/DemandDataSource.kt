package com.wajdihh.data.repository

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single

/**
 * Created by wajdihh on 3/14/19.
 * DemandLocalDataSource
 */

interface DemandLocalDataSource {

    fun getDemands(): Single<DemandsPaging>

    fun saveDemands(list: List<Demand>)
}

interface DemandRemoteDataSource {

    fun getDemands(params: SearchRequest?): Single<DemandsPaging>

    fun getDemandDetails(id: String): Single<Demand>
}