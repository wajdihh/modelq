package com.wajdihh.data.repository

import com.wajdihh.data.mapper.toDemand
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.repository.DemandRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by wajdihh on 3/12/19.
 *
 * Implements DOMAIN Layer repository, and provides the methods to handle local and remote data
 */
class DemandRepositoryImpl @Inject constructor(private val isOnline: Boolean,
                                               private val demandService: DemandService,
                                               private val demandDao: DemandDao) : DemandRepository {


    override fun getDemands(lat: Double,
                            lng: Double,
                            radius: Int,
                            type: String,
                            page: Int,
                            perPage: Int): Single<DemandsPaging> {
        return if (isOnline)
            demandService.getDemands(lat, lng, radius, type, page, perPage).map { it.toDemandsPaging() }
        else //TODO change to dao
            demandService.getDemands(lat, lng, radius, type, page, perPage).map { it.toDemandsPaging() }

    }

    override fun getDemandDetails(id: String): Single<Demand> {
        return demandService.getDemand(id).map { it.toDemand() }
    }
}