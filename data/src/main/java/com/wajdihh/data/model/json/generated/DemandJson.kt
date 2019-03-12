package com.wajdihh.data.model.json.generated

import com.wajdihh.data.model.json.UserJson

/**
 * NB  : j'ai generé cette classe avec le plugin (Generate Kotlin data classes from JSON) Just pour Gagner le temps
 *
 */

data class DemandJson(
        val address: String,
        val answer_id: String,
        val answer_wizard: AnswerWizardJson,
        val asker_id: Int,
        val category_id: Int,
        val comission: String,
        val comments: List<Any>,
        val comments_count: Int,
        val created_at: String,
        val deadline: String,
        val description: String,
        val followed: Boolean,
        val id: Int,
        val lat: String,
        val lng: String,
        val messages_count: Int,
        val offers_amount_accepted: Any,
        val offers_amount_max: Int,
        val offers_amount_min: Int,
        val offers_count: Int,
        val online_payment: Boolean,
        val package_id: String,
        val pricing_type: String,
        val pricing_unit: Any,
        val purchases_price: String,
        val room: Any,
        val share_url: String,
        val state: String,
        val stoot_type: String,
        val title: String,
        val unit_price: String,
        val updated_at: String,
        val user: UserJson
)