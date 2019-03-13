package com.wajdihh.domain.request

/**
 * Created by wajdihh on 3/12/19.
 * Using for http request
 */
data class SearchRequest(val lat: Double,
                         val lng: Double,
                         val radius: Int,
                         val type: String,
                         val page: Int,
                         val perPage: Int)