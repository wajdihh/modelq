package com.wajdihh.data.repository

import com.wajdihh.data.mapper.toDemand
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.data.utils.NoConnectivityException
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.repository.DemandRepository
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by wajdihh on 3/12/19.
 *
 * Implements DOMAIN Layer repository, and provides the methods to handle local and remote data
 */
class DemandRepositoryImpl @Inject constructor(private val demandService: DemandService,
                                               private val demandDao: DemandDao) : DemandRepository {


    override fun getDemands(params: SearchRequest?): Single<DemandsPaging> {
        return demandService.getDemands(params?.lat,
                params?.lng,
                params?.radius,
                params?.type,
                params?.page,
                params?.perPage).map { it.toDemandsPaging() }.onErrorResumeNext {
            if (it is NoConnectivityException)
                demandDao.getDemands().map { it.toDemandsPaging() }
            else
                Single.error(it)
        }
    }

    override fun getDemandDetails(id: String): Single<Demand> {
        return demandService.getDemand(id).map { it.toDemand() }
    }
}