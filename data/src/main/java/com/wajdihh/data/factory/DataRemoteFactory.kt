package com.wajdihh.data.factory

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.data.utils.ConnectivityInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by wajdihh on 3/12/19.
 * In this file, we created a factory to handle all dependencies between retrofit , gson, OKHttp
 */
object DataRemoteFactory {


    fun createDemandService(baseUrl: String, connectivityInterceptor: ConnectivityInterceptor): DemandService {
        val retrofit = createNetworkingBundle(baseUrl, connectivityInterceptor)
        return retrofit.create(DemandService::class.java)
    }

    /**
     * Add Gson, OKHttp and interceptor to retrofit object
     */
    private fun createNetworkingBundle(baseUrl: String, httpLoggingInterceptor: Interceptor): Retrofit {
        val httClient = createOkHttpClient(httpLoggingInterceptor)
        return createRetrofit(baseUrl, httClient, createGson())
    }

    /**
     * Create retrofit object to access to the web service API
     */
    private fun createRetrofit(baseUrl: String, okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    /**
     * Create our HTTP client
     */
    private fun createOkHttpClient(httpLoggingInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
    }

    /**
     * Create GSON parcer for getting data in the right format from the web service
     */
    private fun createGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
    }
}