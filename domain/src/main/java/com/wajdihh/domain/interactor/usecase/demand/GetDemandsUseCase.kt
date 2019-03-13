package com.wajdihh.domain.interactor.usecase.demand

import com.wajdihh.domain.executor.PostExecutionThread
import com.wajdihh.domain.executor.ThreadExecutor
import com.wajdihh.domain.interactor.SingleUseCase
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.repository.DemandRepository
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by wajdihh on 3/11/19.
 * To respect the SOLID principals, we are using Uses Cases strategy
 *
 * -> As user I should retrieve the list of demands
 */
class GetDemandsUseCase @Inject constructor(private val demandRepository: DemandRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread) : SingleUseCase<DemandsPaging, SearchRequest?>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: SearchRequest?): Single<DemandsPaging> = demandRepository.getDemands(params)
}