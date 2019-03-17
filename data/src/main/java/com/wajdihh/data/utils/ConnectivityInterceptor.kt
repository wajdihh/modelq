package com.wajdihh.data.utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by wajdihh on 3/13/19.
 * This class is used to detect connectivity and User access Token
 */
class ConnectivityInterceptor(private val isOnline: Boolean,
                              private val xContext: String = "",
                              private val acceptVersion: String = "",
                              private val xRequestId: String = "") : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {

        if (!isOnline)
            throw NoConnectivityException()

        val builder = chain?.request()?.newBuilder()
        //test if token user is set it
        return if (!xContext.isEmpty()) {
            builder?.apply {
                addHeader("X-context", xContext)
                addHeader("Accept-Version", acceptVersion)
                addHeader("X-Request-Id", xRequestId)
            }
            chain?.proceed(builder?.build())!!
        } else
            chain!!.proceed(builder!!.build())
    }

}