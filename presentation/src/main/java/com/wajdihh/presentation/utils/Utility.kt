package com.wajdihh.presentation.utils

import android.location.Location
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by wajdihh on 3/15/19.
 * Utility
 */
class Utility {
    companion object {
        fun getCalculateDistance(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Float {
            val loc1 = Location("")
            loc1.latitude = lat1
            loc1.longitude = lng1

            val loc2 = Location("")
            loc2.latitude = lat2
            loc2.longitude = lng2

            val distance = (loc1.distanceTo(loc2) / 1000)
            return String.format(Locale.ENGLISH,"%.2f", distance).toFloat()
        }

        fun getSinceToDay(givenDate: String): Long {
            val diff = getSince(givenDate)
            val seconds = diff / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            return hours / 24
        }

        fun getSinceToWeek(givenDate: String): Long {
            return getSinceToDay(givenDate) / 7
        }

        fun getSinceToMonth(givenDate: String): Long {
            return getSinceToDay(givenDate) / 30
        }

        private fun getSince(givenDate: String): Long {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.FRANCE)
            val targetDate = sdf.parse(givenDate)
            return Date().time - targetDate.time
        }
    }
}