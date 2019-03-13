package com.wajdihh.modelq.di.module

import android.content.Context
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.data.source.remote.createDemandRepository
import com.wajdihh.domain.repository.DemandRepository
import com.wajdihh.modelq.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wajdihh on 3/13/19.
 *
 * We provide in It, all the DOMAIN LAYER's repositories, which needed to connect between Data - Domain - Presentation
 * in clean architecture
 */
@Module
class DomainRepositoryModule {

    @Provides
    @Singleton
    fun provideDemandRepository(context: Context, demandService: DemandService, demandDao: DemandDao): DemandRepository {
        val isMock = context.resources.getBoolean(R.bool.enable_mock_mode)
        return createDemandRepository(context, isMock, demandService, demandDao)
    }
}