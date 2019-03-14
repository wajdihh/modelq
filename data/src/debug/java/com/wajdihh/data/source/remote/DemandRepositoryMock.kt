package com.wajdihh.data.source.remote

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.wajdihh.data.mapper.toDemand
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.model.json.DemandJson
import com.wajdihh.data.model.json.DemandsPagingJson
import com.wajdihh.data.repository.DemandRepositoryImpl
import com.wajdihh.data.source.Utils
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.repository.DemandRepository
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by wajdihh on 3/13/19.
 * Mock
 */
class DemandServiceMock(private val context: Context) : DemandRepository {


    private val gson = Gson()

    override fun getDemands(params: SearchRequest?): Single<DemandsPaging> {
        return Single.fromCallable {
            val json = Utils.getAssetsJSON(context, LIST_FILE_NAME)
            Log.d("DemandServiceMock : getDemands", "Json: " + json)
            gson.fromJson(json, DemandsPagingJson::class.java).toDemandsPaging()
        }
    }

    override fun getDemandDetails(id: String): Single<Demand> {
        return Single.fromCallable {
            val json = Utils.getAssetsJSON(context, DETAIL_FILE_NAME)
            Log.d("DemandServiceMock : getDemandDetails", "Json: " + json)
            gson.fromJson(json, DemandJson::class.java).toDemand()
        }
    }
    override fun saveDemands(list: List<Demand>): Completable = Completable.complete()
}

fun createDemandRepository(context: Context, isMock: Boolean, demandService: DemandService, demandDao: DemandDao): DemandRepository {
    return if (!isMock)
        DemandRepositoryImpl(demandService, demandDao)
    else
        DemandServiceMock(context)
}

private const val LIST_FILE_NAME = "mock/demand_list.json"
private const val DETAIL_FILE_NAME = "mock/demand_detail.json"