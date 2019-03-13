package com.wajdihh.data.model.json

import com.google.gson.annotations.SerializedName

data class DemandJson(
        val address: String,
        @SerializedName("answer_id") val answerId: String,
        @SerializedName("answer_wizard") val answerWizard: AnswerWizardJson,
        @SerializedName("asker_id") val askerId: Int,
        @SerializedName("category_id") val category_id: Int,
        val comission: String,
        @SerializedName("comments_count") val commentsCount: Int,
        @SerializedName("created_at") val createdAt: String,
        val deadline: String,
        val description: String,
        val followed: Boolean,
        val id: Int,
        val lat: String,
        val lng: String,
        @SerializedName("messages_count") val messagesCount: Int,
        @SerializedName("offers_amount_accepted") val offersAmountAccepted: Int,
        @SerializedName("offers_amount_max") val offersAmountMax: Int,
        @SerializedName("offers_amount_min") val offersAmountMin: Int,
        @SerializedName("offers_count") val offersCount: Int,
        @SerializedName("online_payment") val onlinePayment: Boolean,
        @SerializedName("package_id") val packageId: String,
        @SerializedName("pricing_type") val pricingType: String,
        @SerializedName("pricing_unit") val pricingUnit: String,
        @SerializedName("purchases_price") val purchasesPrice: String,
        @SerializedName("share_url") val shareUrl: String,
        val state: String,
        @SerializedName("stoot_type") val stootType: String,
        val title: String,
        @SerializedName("unit_price") val unitPrice: String,
        @SerializedName("updated_at") val updatedAt: String,
        val user: UserJson
)