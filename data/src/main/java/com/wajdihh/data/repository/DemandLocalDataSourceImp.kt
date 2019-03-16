package com.wajdihh.data.repository

import com.wajdihh.data.mapper.toDemandEntity
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import io.reactivex.Single

/**
 * Created by wajdihh on 3/14/19.
 * for local repo
 */
class DemandLocalDataSourceImp(private val demandDao: DemandDao) : DemandLocalDataSource {

    override fun getDemands(): Single<DemandsPaging> = demandDao.getDemands().map {
        it.toDemandsPaging()
    }

    override fun saveDemands(list: List<Demand>) {
        demandDao.saveDemands(list.map { it.toDemandEntity() })
    }
}