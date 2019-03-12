package com.wajdihh.data.model.json

import com.google.gson.annotations.SerializedName

data class UserJson(
        @SerializedName("common_friends") val commonFriends: Boolean,
        @SerializedName("created_at") val createdAt: String,
        @SerializedName("firstname") val firstName: String,
        @SerializedName("lastname") val lastName: String,
        @SerializedName("last_sign_in_at") val lastSignInAt: String,
        @SerializedName("thumb_picture_url") val thumbPictureUrl: String,
        @SerializedName("last_sprofile_picture_urlign_in_at") val profilePictureUrl: String)