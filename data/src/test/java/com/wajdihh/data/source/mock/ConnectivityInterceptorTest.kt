package com.wajdihh.data.source.mock

import okhttp3.Interceptor
import okhttp3.Response


class ConnectivityInterceptorTest : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val builder = chain?.request()?.newBuilder()
        builder?.apply {
            addHeader("X-context", DataConfig.XContext)
            addHeader("Accept-Version", DataConfig.AcceptVersion)
            addHeader("X-Request-Id", DataConfig.XRequestId)
        }
        return chain?.proceed(builder?.build())!!
    }
}