package com.wajdihh.data.utils

import java.io.IOException

/**
 * Created by wajdihh on 3/13/19.
 * This allows one to specifically handle network connectivity issues before hitting Retrofit.
 */
class NoConnectivityException : IOException() {

    override fun getLocalizedMessage(): String {
        return "No network available, please check your WiFi or Data connection"
    }
}