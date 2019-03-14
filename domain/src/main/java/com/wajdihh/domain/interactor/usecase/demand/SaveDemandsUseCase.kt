package com.wajdihh.domain.interactor.usecase.demand

import com.wajdihh.domain.executor.PostExecutionThread
import com.wajdihh.domain.executor.ThreadExecutor
import com.wajdihh.domain.interactor.CompletableUseCase
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.repository.DemandRepository
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by wajdihh on 3/11/19.

 * To respect the SOLID principals, we are using Uses Cases strategy
 *
 * -> As user I should save demands in cache for offline mode
 */
class SaveDemandsUseCase @Inject constructor(private val demandRepository: DemandRepository,
                                             threadExecutor: ThreadExecutor,
                                             postExecutionThread: PostExecutionThread) : CompletableUseCase<List<Demand>?>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: List<Demand>?): Completable = demandRepository.saveDemands(params!!)

}