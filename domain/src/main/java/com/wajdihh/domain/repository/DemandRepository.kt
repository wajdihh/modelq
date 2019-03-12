package com.wajdihh.domain.repository

import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import io.reactivex.Single

/**
 * Created by wajdihh on 3/11/19.
 * Contract to implement by the DATA Layer to communicate with DOMAIN Layer
 */
interface DemandRepository {

    fun getDemands(lat: Double,
                   lng: Double,
                   radius: Int,
                   type: String,
                   page: Int,
                   perPage: Int): Single<DemandsPaging>

    fun getDemandDetails(id: String): Single<Demand>

}