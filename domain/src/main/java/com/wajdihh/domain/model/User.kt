package com.wajdihh.domain.model

/**
 * Created by wajdihh on 3/11/19.
 * Demand model
 */
data class User(val firstName: String,
                val lastName: String,
                val lastSignInAt: String,
                val profilePictureUrl: String?,
                val profileThumbUrl: String?)