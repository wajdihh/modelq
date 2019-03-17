package com.wajdihh.data.model.json

import com.google.gson.annotations.SerializedName

data class UserJson(
        val followed: Boolean?,
        val id: Int?,
        @SerializedName("firstname") val firstName: String,
        @SerializedName("lastname") val lastName: String,
        @SerializedName("eval_count") val evalCount: Int,
        @SerializedName("last_sign_in_at") val lastSignInAt: String,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("profile_picture_url") val profilePictureUrl: String?,
        @SerializedName("thumb_picture_url") val thumbPictureUrl: String?
)