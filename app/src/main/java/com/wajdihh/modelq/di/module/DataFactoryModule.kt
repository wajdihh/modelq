package com.wajdihh.modelq.di.module

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import com.wajdihh.data.factory.DataLocalFactory
import com.wajdihh.data.factory.DataRemoteFactory
import com.wajdihh.data.source.local.DemandDao
import com.wajdihh.data.source.remote.DemandService
import com.wajdihh.modelq.R
import com.wajdihh.modelq.utils.LiveNetworkMonitorUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wajdihh on 3/13/19.
 *
 * nside this module, we provide all stuff related to fetching Data (from cloud, DB etc..)
 */
@Module
class DataFactoryModule {


    /**
     * ------------------------------ REMOTE -------------------------------------------
     */

    @Provides
    @Singleton
    fun provideDemandService(resource: Resources,
                             liveNetworkMonitorUtil: LiveNetworkMonitorUtil,
                             sharedPreferences: SharedPreferences): DemandService {

        val baseURL = resource.getString(R.string.URL_WEB_SERVICE)
        val isOnline = liveNetworkMonitorUtil.isConnected()
        val userToken = sharedPreferences.getString(resource.getString(R.string.pref_user_access_token), "")

        return DataRemoteFactory.createDemandService(baseURL, isOnline, userToken)
    }

    /**
     * ------------------------------ LOCAL -------------------------------------------
     */

    @Provides
    @Singleton
    fun provideDemandsDao(context: Context): DemandDao = DataLocalFactory.createDaoDemand(context)
}