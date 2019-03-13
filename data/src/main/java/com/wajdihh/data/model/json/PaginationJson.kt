package com.wajdihh.data.model.json

import com.google.gson.annotations.SerializedName

data class PaginationJson(
        @SerializedName("current_page") val currentPage: Int,
        @SerializedName("next_page") val nextPage: Int?,
        @SerializedName("per_page") val perPage: Int,
        @SerializedName("previous_page") val previousPage: Int?,
        val total: Int
)