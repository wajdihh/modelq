package com.wajdihh.domain.model

/**
 * Created by wajdihh on 3/11/19.
 * Demand model
 */
data class User(val firstName: String,
                val lastName: String?,
                val name: String?,
                val evalCount: Int,
                val lastSignInAt: String?,
                val profilePictureUrl: String?,
                val profileThumbUrl: String?)