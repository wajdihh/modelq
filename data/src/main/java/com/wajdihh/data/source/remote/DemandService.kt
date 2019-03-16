package com.wajdihh.data.source.remote

import com.wajdihh.data.model.json.DemandJson
import com.wajdihh.data.model.json.DemandsPagingJson
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by wajdihh on 3/11/19.
 * Remote service
 */
interface DemandService {

    @GET("/stoots.json")
    fun getDemands(@Query("lat") lat: Double?,
                   @Query("lng") lng: Double?,
                   @Query("radius") radius: Int?,
                   @Query("stoot_type") type: String?,
                   @Query("page") page: Int?,
                   @Query("per_page") perPage: Int?): Single<DemandsPagingJson>


    @GET("/demands{id}/details")
    fun getDemand(@Path("id") id: String): Single<DemandJson>
}