package com.wajdihh.data.repository

import com.wajdihh.data.mapper.toDemand
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single

/**
 * Created by wajdihh on 3/14/19.
 * for remote repo
 */
class DemandRemoteDataSourceImpl(private val demandService: DemandService) : DemandRemoteDataSource {

    override fun getDemands(params: SearchRequest?): Single<DemandsPaging> {
        return demandService.getDemands(params?.lat,
                params?.lng,
                params?.radius,
                params?.type,
                params?.page,
                params?.perPage).map { it.toDemandsPaging() }
    }

    override fun getDemandDetails(id: String): Single<Demand> {
        return demandService.getDemand(id).map { it.toDemand() }
    }
}