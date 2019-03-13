package com.wajdihh.modelq.di.module

import com.wajdihh.data.repository.DemandRepositoryImpl
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.domain.repository.DemandRepository
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
    fun provideDemandRepository(demandService: DemandService, demandDao: DemandDao): DemandRepository {
        return DemandRepositoryImpl(demandService, demandDao)
    }
}