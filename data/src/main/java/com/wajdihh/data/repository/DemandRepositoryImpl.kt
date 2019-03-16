package com.wajdihh.data.repository

import com.wajdihh.data.utils.NoConnectivityException
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.repository.DemandRepository
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single

/**
 * Created by wajdihh on 3/12/19.
 *
 * Implements DOMAIN Layer repository, and provides the methods to handle local and remote data
 */
class DemandRepositoryImpl(private val localDemandDataSource: DemandLocalDataSource,
                           private val remoteDemandDataSource: DemandRemoteDataSource) : DemandRepository {

    override fun getDemands(params: SearchRequest?): Single<DemandsPaging> {
        return remoteDemandDataSource.getDemands(params)
                .doOnSuccess {
                    localDemandDataSource.saveDemands(it.demands)
                }
                .onErrorResumeNext {
                    if (it is NoConnectivityException)
                        localDemandDataSource.getDemands()
                    else
                        Single.error(it)
                }
    }

    override fun getDemandDetails(id: Int): Single<Demand> {
        return remoteDemandDataSource.getDemandDetails(id)
    }

}