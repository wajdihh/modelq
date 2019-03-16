package com.wajdihh.modelq.di.module

import com.wajdihh.domain.interactor.usecase.demand.GetDemandUseCase
import com.wajdihh.domain.interactor.usecase.demand.GetDemandsUseCase
import com.wajdihh.modelq.di.scope.PerActivity
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailPresenter
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailPresenterImpl
import com.wajdihh.presentation.mvp.demand.list.DemandListPresenter
import com.wajdihh.presentation.mvp.demand.list.DemandListPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by wajdihh on 3/13/19.
 *
 * Inside this module, we provide all the required presenters for the the UI app
 */
@Module
class PresenterModule {

    @Provides
    @PerActivity
    fun providerDemandListPresenter(getDemandsUseCase: GetDemandsUseCase)
            : DemandListPresenter = DemandListPresenterImpl(getDemandsUseCase)

    @Provides
    @PerActivity
    fun providerDemandDetailPresenter(getDemandUseCase: GetDemandUseCase)
            : DemandDetailPresenter = DemandDetailPresenterImpl(getDemandUseCase)
}