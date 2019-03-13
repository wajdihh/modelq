package com.wajdihh.modelq.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

/**
 * Created by wajdihh on 3/13/19.
 * Networking utilities
 */
open class LiveNetworkMonitorUtil @Inject constructor(private val context: Context) {

    /**
     * Test if connected to internet
     */
    fun isConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}