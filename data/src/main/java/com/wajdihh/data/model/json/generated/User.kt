package com.wajdihh.data.model.json.generated

/**
 * NB  : j'ai generé cette classe avec le plugin (Generate Kotlin data classes from JSON) Just pour Gagner le temps
 */
data class User(
        val common_friends: Boolean,
        val created_at: String,
        val eval_avg: String,
        val eval_count: Int,
        val firstname: String,
        val followed: Boolean,
        val id: Int,
        val last_sign_in_at: String,
        val lastname: String,
        val profile_picture_url: Any,
        val response_rate: Int,
        val response_time: Int,
        val thumb_picture_url: Any
)