package com.wajdihh.data.source.remote

import android.content.Context
import com.google.gson.Gson
import com.wajdihh.data.mapper.toDemand
import com.wajdihh.data.mapper.toDemandsPaging
import com.wajdihh.data.model.json.DemandJson
import com.wajdihh.data.model.json.DemandsPagingJson
import com.wajdihh.data.repository.DemandRemoteDataSource
import com.wajdihh.data.repository.DemandRemoteDataSourceImpl
import com.wajdihh.data.source.Utils
import com.wajdihh.domain.model.Demand
import com.wajdihh.domain.model.DemandsPaging
import com.wajdihh.domain.request.SearchRequest
import io.reactivex.Single

/**
 * Created by wajdihh on 3/13/19.
 * Mock
 */
class DemandRemoteDataSourceMock(private val context: Context) : DemandRemoteDataSource {

    private val gson = Gson()

    override fun getDemands(params: SearchRequest?): Single<DemandsPaging> {
        return Single.fromCallable {
            val json = Utils.getAssetsJSON(context, LIST_FILE_NAME)
            gson.fromJson(json, DemandsPagingJson::class.java).toDemandsPaging()
        }
    }

    override fun getDemandDetails(id: Int): Single<Demand> {
        return Single.fromCallable {
            val json = Utils.getAssetsJSON(context, DETAIL_FILE_NAME)
            gson.fromJson(json, DemandJson::class.java).toDemand()
        }
    }
}

fun createDemandRemoteDataSource(context: Context,
                                 isMock: Boolean,
                                 demandService: DemandService): DemandRemoteDataSource {
    return if (!isMock)
        DemandRemoteDataSourceImpl(demandService)
    else
        DemandRemoteDataSourceMock(context)
}

private const val LIST_FILE_NAME = "mock/demand_list.json"
private const val DETAIL_FILE_NAME = "mock/demand_detail.json"