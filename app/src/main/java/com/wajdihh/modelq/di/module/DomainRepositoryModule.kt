package com.wajdihh.modelq.di.module

import android.content.Context
import com.wajdihh.data.repository.DemandLocalDataSource
import com.wajdihh.data.repository.DemandLocalDataSourceImp
import com.wajdihh.data.repository.DemandRemoteDataSource
import com.wajdihh.data.repository.DemandRepositoryImpl
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.data.source.remote.createDemandRemoteDataSource
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
    fun provideDemandRepository(demandLocalDataSource: DemandLocalDataSource, demandRemoteDataSource: DemandRemoteDataSource): DemandRepository {
        return DemandRepositoryImpl(demandLocalDataSource, demandRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideDemandRemoteDataSource(context: Context, demandService: DemandService): DemandRemoteDataSource {
        val isMock = context.resources.getBoolean(R.bool.enable_mock_mode)
        return createDemandRemoteDataSource(context, isMock, demandService)
    }

    @Provides
    @Singleton
    fun provideDemandLocalDataSource(demandDao: DemandDao): DemandLocalDataSource {
        return DemandLocalDataSourceImp(demandDao)
    }
}