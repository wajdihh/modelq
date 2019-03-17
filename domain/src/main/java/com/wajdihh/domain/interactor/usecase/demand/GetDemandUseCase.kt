package com.wajdihh.domain.interactor.usecase.demand

import com.wajdihh.domain.executor.PostExecutionThread
import com.wajdihh.domain.executor.ThreadExecutor
import com.wajdihh.domain.interactor.SingleUseCase
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.repository.DemandRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by wajdihh on 3/11/19.

 * To respect the SOLID principals, we are using Uses Cases strategy
 *
 * -> As user I should retrieve the list of demands
 */
class GetDemandUseCase @Inject constructor(private val demandRepository: DemandRepository,
                                           threadExecutor: ThreadExecutor,
                                           postExecutionThread: PostExecutionThread) : SingleUseCase<Demand, Int>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Int?): Single<Demand> = demandRepository.getDemandDetails(params!!)
}