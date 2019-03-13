package com.wajdihh.data.source

import android.content.Context

/**
 * Created by wajdihh on 3/13/19.
 * to parse json file
 */
class Utils {

    companion object {

        fun getAssetsJSON(context: Context, fileName: String): String {
            var json = ""
            try {
                val inputStream = context.assets.open(fileName)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)

            } catch (e: Throwable) {
                e.printStackTrace()
            }

            return json
        }
    }
}